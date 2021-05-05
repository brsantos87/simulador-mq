package br.org.caixa.jms;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;


@ApplicationScoped
public class JMSConsumer implements Runnable {

    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    void onStart(@Observes StartupEvent ev) {
        scheduler.scheduleWithFixedDelay(this, 0L, 1L, TimeUnit.SECONDS);
    }

    void onStop(@Observes ShutdownEvent ev) {
        scheduler.shutdown();
    }

    @Override
    public void run() {
    	
//    	QueueConnection queueConnection = null;
//		QueueSession queueSession = null;
//		QueueSender queueSender = null;
//		QueueReceiver queueReceiver = null;
//
//		QueueConnectionFactory queueConnectionFactory = getConnection();
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
//        try (JMSContext context = connectionFactory.createContext(Session.AUTO_ACKNOWLEDGE)) {
//            javax.jms.JMSConsumer consumer = context.createConsumer(context.createQueue("DEV.QUEUE.1"));
//            while (true) {
//                Message message = consumer.receive();
//                if (message == null) {
//                    return;
//                }
//                System.out.println(message);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }



}