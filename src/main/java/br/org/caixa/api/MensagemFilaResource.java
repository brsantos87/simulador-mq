package br.org.caixa.api;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.jboss.logging.Logger;

import br.org.caixa.api.model.MensagemFilaDto;
import br.org.caixa.persistencia.entidade.MensagemFila;
import br.org.caixa.persistencia.repository.FilaRepository;
import br.org.caixa.persistencia.repository.MensagemFilaRepository;

@Path("/fila/mensagem")
public class MensagemFilaResource {
	
	private final Logger logger = Logger.getLogger(MensagemFilaResource.class);

	@Inject
	MensagemFilaRepository mensagemFilaRepository;
	
	@Inject
	FilaRepository filaRepository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getList() {
		return Response.ok(mensagemFilaRepository.findAll().list()).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id) {
        return Response.ok(mensagemFilaRepository.findById(id)).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(MensagemFilaDto msgDto) {
    	MensagemFila msgFila = new MensagemFila();
    	
    	msgFila.setDescricao(msgDto.getDescricao());
    	msgFila.setMensagem(msgDto.getMensagem());
    	msgFila.setAtivo(msgDto.isAtivo());
    	msgFila.setFila(filaRepository.findById(msgDto.getIdFila()));
    	
    	logger.info("id fila: " + msgFila.getFila().getId());
    	
        mensagemFilaRepository.persist(msgFila);
        return Response.created(UriBuilder
                .fromResource(MensagemFilaResource.class)
                .path(Long.toString(msgFila.getId()))
                .build()
            ).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(MensagemFilaDto dto) {
    	
    	var msgFila = mensagemFilaRepository.findById(dto.getId());
    	msgFila.setDescricao(dto.getDescricao());
    	msgFila.setMensagem(dto.getMensagem());
    	msgFila.setAtivo(dto.isAtivo());
    	
    	mensagemFilaRepository.isPersistent(msgFila);
    	
    	return Response.ok(msgFila).build();

    }
    
    @DELETE
    @Transactional
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        return Response.ok(mensagemFilaRepository.deleteById(id)).build();
    }
    
    @GET
    @Path("/ativo/{id}")
    public Response getMensagemAtiva(@PathParam("id") String id) {
        return Response.ok(mensagemFilaRepository.findAtivoByNomeFila(id)).build();
    }

}