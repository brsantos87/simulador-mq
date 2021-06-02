package br.org.caixa.api;

import java.util.List;
import java.util.stream.Collectors;

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

import br.org.caixa.api.model.FilaDto;
import br.org.caixa.api.model.FilaRetornoDto;
import br.org.caixa.api.model.MensagemFilaDto;
import br.org.caixa.persistencia.entidade.Fila;
import br.org.caixa.persistencia.entidade.MensagemFila;
import br.org.caixa.persistencia.repository.FilaRepository;
import br.org.caixa.persistencia.repository.MensagemFilaRepository;
import io.quarkus.panache.common.Sort;

@Path("/fila")
public class FilaResource {
	
	private final Logger logger = Logger.getLogger(FilaResource.class);

	@Inject
	FilaRepository filaRepository;
	
	@Inject
	MensagemFilaRepository mensagemFilaRepository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getList() {
		List<Fila> filas = filaRepository.findAll(Sort.ascending("nome")).list();
		List<FilaRetornoDto> filasRetorno = filas.stream().map(fila -> 
			new FilaRetornoDto(
					fila.getId(), 
					fila.getNome(), 
					fila.getFilaMensagens().stream().map(
							msg -> new MensagemFilaDto(
									fila.getId(), 
									msg.getDescricao(), 
									msg.getMensagem(), 
									msg.isAtivo())).collect(Collectors.toList())
		)).collect(Collectors.toList());
		return Response.ok(filasRetorno).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id) {
		var fila = filaRepository.findById(id);
		var retorno = new FilaRetornoDto(
				fila.getId(), 
				fila.getNome(), 
				fila.getFilaMensagens().stream().map(
						msg -> new MensagemFilaDto(
								msg.getId(), 
								msg.getDescricao(),
								msg.getMensagem(), 
								msg.isAtivo())).collect(Collectors.toList()));
        return Response.ok(retorno).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(FilaDto filaDto) {
    	Fila fila = new Fila();
    	
    	fila.setNome(filaDto.getNome());
    	
        filaRepository.persist(fila);
        return Response.created(UriBuilder
                .fromResource(FilaResource.class)
                .path(Long.toString(fila.getId()))
                .build()
            ).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(FilaDto filaDto) {
    	
    	Fila fila = filaRepository.findById(filaDto.getId());
    	fila.setNome(filaDto.getNome());

    	return Response.ok(fila).build();

    }
    
    @DELETE
    @Transactional
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        return Response.ok(filaRepository.deleteById(id)).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("{id}/mensagem")
    public Response createMensagem(@PathParam("id") Long idFila, MensagemFilaDto msgDto) {
    	var msgFila = new MensagemFila();
    	
    	msgFila.setDescricao(msgDto.getDescricao());
    	msgFila.setMensagem(msgDto.getMensagem());
    	msgFila.setAtivo(msgDto.isAtivo());
    	msgFila.setFila(filaRepository.findById(idFila));
    	
    	logger.info("id fila: " + msgFila.getFila().getId());
    	
        mensagemFilaRepository.persist(msgFila);
        mensagemFilaRepository.ativaMsg(msgFila.getFila().getId(),msgFila.getId());
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
    @Path("{id}/mensagem")
    public Response updateMensagem(@PathParam("id") Long idFila, MensagemFilaDto dto) {
    	
    	var msgFila = mensagemFilaRepository.findById(dto.getId());
    	msgFila.setDescricao(dto.getDescricao());
    	msgFila.setMensagem(dto.getMensagem());
    	msgFila.setAtivo(dto.isAtivo());
    	
    	mensagemFilaRepository.isPersistent(msgFila);
    	mensagemFilaRepository.ativaMsg(msgFila.getFila().getId(),msgFila.getId());
    	
    	return Response.ok(msgFila).build();

    }
    
}