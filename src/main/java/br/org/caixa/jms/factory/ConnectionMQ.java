package br.org.caixa.jms.factory;

import java.util.ResourceBundle;

import javax.jms.JMSException;

import com.ibm.mq.jms.MQConnectionFactory;

public class ConnectionMQ {


	private ResourceBundle properties;

	private ResourceBundle getProperties() {
		if (properties == null)
			properties = ResourceBundle.getBundle("mq.properties");
		return properties;
	}

	public MQConnectionFactory getConnection() {
		MQConnectionFactory cf = new MQConnectionFactory();
		try {
			cf.setHostName(getProperties().getString("mq.hostname"));
			cf.setChannel(getProperties().getString("mq.channel"));
			cf.setQueueManager(getProperties().getString("mq.queueManager"));
			cf.setTransportType(com.ibm.msg.client.wmq.common.CommonConstants.WMQ_CM_CLIENT);
			cf.setPort(Integer.parseInt(getProperties().getString("mq.port")));
		} catch (NumberFormatException | JMSException e) {
			e.printStackTrace();
		}

		return cf;
	}

//	public void sendMsg(String mensagem) {
//		QueueConnection queueConnection = null;
//		QueueSession queueSession = null;
//		QueueSender queueSender = null;
//		QueueReceiver queueReceiver = null;
//		this.initialContext = new InitialContext();
//
//		QueueConnectionFactory queueConnectionFactory = getConnection().;
//		queueConnection = queueConnectionFactory.createQueueConnection();
//
//		Queue toQueue = (Queue) lookup(propriedadesMQ.getFilaRequisicao());
//
//		queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
//		queueConnection.start();
//		queueSender = queueSession.createSender(toQueue);
//
//		TextMessage toMessage = queueSession.createTextMessage();
//		toMessage.setStringProperty("JMS_IBM_Character_Set", "819");
//		toMessage.setStringProperty("JMS_IBM_Format", "MQSTR");
//		toMessage.setText(mensagem);
//
//		queueSender.send(toMessage);
//
//
//	}
//
//	public Object lookup(String name) throws NamingException {
//		return initialContext.lookup(name);
//	}

}
