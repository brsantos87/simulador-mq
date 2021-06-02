package br.org.caixa.api.exception.handler;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class JAXRSExceptionMapper implements ExceptionMapper<IllegalArgumentException>{
	
	final String EXCEPTION_MESSAGE = "invalid request data: ";
	final String RESPONSE_TYPE = "text/plain";
	
	@Override
	public Response toResponse(IllegalArgumentException e) {
		return Response.serverError()
				.entity(EXCEPTION_MESSAGE + e.getMessage())
				.type(RESPONSE_TYPE)
				.status(400)
				.build();
	}

}
