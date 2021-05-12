package br.org.caixa.api;

import java.util.ArrayList;
import java.util.List;

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
import br.org.caixa.api.model.MensagemServicoDto;
import br.org.caixa.persistencia.entidade.MensagemServico;
import br.org.caixa.persistencia.entidade.ServicoSibarKey;
import br.org.caixa.persistencia.repository.MensagemServicoRepository;
import br.org.caixa.persistencia.repository.ServicoSibarRepository;

@Path("/servico/mensagem")
public class MensagemServicoResource {
	
	private final Logger logger = Logger.getLogger(MensagemServicoResource.class);

	@Inject
	MensagemServicoRepository mensagemServicoRepository;
	
	@Inject
	ServicoSibarRepository servicoSibarRepository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getList() {
		return Response.ok(mensagemServicoRepository.findAll().list()).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id) {
        return Response.ok(mensagemServicoRepository.findById(id)).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(MensagemServicoDto dto) {
    	MensagemServico msg = new MensagemServico();
    	
    	
    	msg.setDescricao(dto.getDescricao());
    	msg.setAtivo(dto.isAtivo());
    	msg.setMensagem(dto.getMensagem());
    	msg.setServicoSibar(servicoSibarRepository.findById(dto.getIdServico()));
    	
        mensagemServicoRepository.persist(msg);
        return Response.created(UriBuilder
                .fromResource(MensagemServicoResource.class)
                .path(Long.toString(msg.getId()))
                .build()
            ).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(MensagemFilaDto dto) {
    	
    	MensagemServico msg = mensagemServicoRepository.findById(dto.getId());
    	msg.setDescricao(dto.getDescricao());
    	msg.setMensagem(dto.getMensagem());
    	msg.setAtivo(dto.isAtivo());
    	
    	mensagemServicoRepository.isPersistent(msg);
    	
    	return Response.ok(msg).build();

    }
    
    @DELETE
    @Transactional
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        return Response.ok(mensagemServicoRepository.deleteById(id)).build();
    }
    
    @GET
    @Path("/ativo/{id}")
    public Response getMensagemAtiva(@PathParam("id") String id) {
    	List<ServicoSibarKey> lista = new ArrayList<>();
    	
    	lista.add(new ServicoSibarKey("nome1","operacao1","1"));
    	lista.add(new ServicoSibarKey("nome2","operacao2","2"));
    	
        return Response.ok(mensagemServicoRepository.findAtivoByServico(lista)).build();
    }
}