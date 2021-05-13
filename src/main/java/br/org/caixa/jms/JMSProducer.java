package br.org.caixa.jms;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;

import br.org.caixa.jms.factory.ConnectionFactoryMQ;


@ApplicationScoped
public class JMSProducer {

    @Inject
    ConnectionFactoryMQ connectionFactoryMQ;

    public void sendMessage(String message, String queue) throws JMSException {
    	
    	try (var connection = connectionFactoryMQ.getConnection().createConnection();
				var session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
				MessageProducer producer = session.createProducer(session.createQueue(queue))) {
    		var toMessage = session.createTextMessage();
            toMessage.setStringProperty("JMS_IBM_Character_Set", "819");
            toMessage.setStringProperty("JMS_IBM_Format", "MQSTR");
            toMessage.setText(message);
            producer.send(toMessage);
    	}
    	
    }
}