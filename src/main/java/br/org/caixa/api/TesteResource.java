package br.org.caixa.api;

import javax.inject.Inject;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import br.org.caixa.api.model.MessageSend;
import br.org.caixa.jms.JMSProducer;

@Path("/simulador")
public class TesteResource {

	@Inject
	JMSProducer producer;

    @PUT
    @Path("/teste")
    public Response sendMessage(MessageSend msg) {
    	try {
    		producer.sendMessage(msg.getMensagem(), msg.getQueue());
    		return Response.ok().build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
		}

    }
}