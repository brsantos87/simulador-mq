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
public class JMSConsumer implements Runnable {

	private static final String DEV_QUEUE_1 = "DEV.QUEUE.1";

	private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

	private final Logger logger = Logger.getLogger(JMSConsumer.class);

	void onStart(@Observes StartupEvent ev) {
		scheduler.scheduleWithFixedDelay(this, 0L, 1L, TimeUnit.SECONDS);
	}

	void onStop(@Observes ShutdownEvent ev) {
		scheduler.shutdown();
	}

	@Override
	public void run() {
		logger.info("Iniciando listener " + DEV_QUEUE_1);
		ConnectionFactoryMQ conectioFactory = new ConnectionFactoryMQ();
		try (Connection connection = conectioFactory.getConnection().createConnection();
				Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
				MessageConsumer consumer = session.createConsumer(session.createQueue(DEV_QUEUE_1))) {
			while (true) {
				connection.start();
				TextMessage textMsg = (TextMessage) consumer.receive();
				if (textMsg.getText() == null) {
					return;
				}
				logger.info(String.format("Received JMSCorrelationID: %s message: %s",textMsg.getJMSCorrelationID() , textMsg.getText()));
			}
		} catch (JMSException e) {
			logger.error(e);
		}

	}

}