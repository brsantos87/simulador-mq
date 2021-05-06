package br.org.caixa.jms;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

import br.org.caixa.jms.factory.ConnectionFactoryMQ;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public abstract class JMSConsumer implements Runnable {

	private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

	private final Logger logger = Logger.getLogger(JMSConsumer.class);

	/**
	 * retorna o intervalo de leitura da fila
	 * 
	 * @return
	 */
	protected long timeScheduleEvent() {
		return ConstantesJMS.DEFAULT_TIME_SCHEDULE_EVENT;
	}

	/**
	 * Retorna a fila que devera ser lida pelo consumer
	 * 
	 * @return
	 */
	protected abstract String getQueueConsumer();

	void onStart(@Observes StartupEvent ev) {
		scheduler.scheduleWithFixedDelay(this, 0L, timeScheduleEvent(), TimeUnit.SECONDS);
	}

	void onStop(@Observes ShutdownEvent ev) {
		scheduler.shutdown();
	}

	@Override
	public void run() {
		logger.info("Iniciado listener " + getQueueConsumer());
		ConnectionFactoryMQ conectioFactory = new ConnectionFactoryMQ();
		try (Connection connection = conectioFactory.getConnection().createConnection();
				Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
				MessageConsumer consumer = session.createConsumer(session.createQueue(getQueueConsumer()))) {
			while (true) {
				connection.start();
				TextMessage textMsg = (TextMessage) consumer.receive();
				if (textMsg.getText() != null) {
					return;
				}
				logger.info(String.format("Recebido JMSCorrelationID: %s message: %s", textMsg.getJMSCorrelationID(),
						textMsg.getText()));
				//TODO obter servico da mensagem
				//TODO consultar servico no banco
				//TODO obter tarefas da mensagem
				//TODO consultar tarefas no banco
				//TODO montar resposta
				//TODO devolver mensagem
			}
		} catch (JMSException e) {
			logger.error(e);
		}
	}

}