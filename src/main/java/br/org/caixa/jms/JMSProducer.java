package br.org.caixa.jms;
import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class JMSProducer {

//    @Inject
//    ConnectionFactory connectionFactory;

    public void sendMessage(String message) {
//        try (JMSContext context = connectionFactory.createContext(Session.AUTO_ACKNOWLEDGE)){
//            context.createProducer().send(context.createQueue("DEV.QUEUE.1"), message);
//        } catch (JMSRuntimeException ex) {
//            // handle exception (details omitted)
//        }
    }
}