package br.org.caixa.jms.factory;

import java.util.ResourceBundle;

import javax.enterprise.context.Dependent;
import javax.jms.JMSException;

import org.apache.log4j.Logger;

import com.ibm.mq.jms.MQConnectionFactory;

@Dependent
public class ConnectionFactoryMQ {

	private final Logger logger = Logger.getLogger(ConnectionFactoryMQ.class);

	private static final ResourceBundle properties = ResourceBundle.getBundle("mq");

	private static ResourceBundle getProperties() {
		return properties;
	}

	public MQConnectionFactory getConnection() {
		MQConnectionFactory cf = new MQConnectionFactory();

		logger.info("Obtendo conexao com fila MQ");
		try {
			cf.setHostName(getProperties().getString("mq.hostname"));
			cf.setChannel(getProperties().getString("mq.channel"));
			cf.setQueueManager(getProperties().getString("mq.queueManager"));
			cf.setTransportType(com.ibm.msg.client.wmq.common.CommonConstants.WMQ_CM_CLIENT);
			cf.setPort(Integer.parseInt(getProperties().getString("mq.port")));
		} catch (NumberFormatException | JMSException e) {
			logger.error("Erro ao conectar ao obter conexao MQ");
		}
		return cf;
	}


}
