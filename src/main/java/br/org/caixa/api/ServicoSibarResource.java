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

import br.org.caixa.api.model.ServicoSibarDto;
import br.org.caixa.persistencia.entidade.ServicoSibar;
import br.org.caixa.persistencia.entidade.ServicoSibarKey;
import br.org.caixa.persistencia.repository.ServicoSibarRepository;

@Path("/servico")
public class ServicoSibarResource {

	@Inject
	ServicoSibarRepository servicoRepository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getList() {
		return Response.ok(servicoRepository.findAll().list()).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id) {
        return Response.ok(servicoRepository.findById(id)).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(ServicoSibarDto dto) {
    	
    	ServicoSibarKey servico = new ServicoSibarKey();
    	
    	servico.setNome(dto.getNome());
    	servico.setOperacao(dto.getOperacao());
    	servico.setVersao(dto.getVersao());
    	
    	ServicoSibar s = new ServicoSibar();
    	s.setKey(servico);
    	
    	servicoRepository.persist(s);
        return Response.created(UriBuilder
                .fromResource(ServicoSibarResource.class)
                .path(Long.toString(s.getId()))
                .build()
            ).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(ServicoSibarDto dto) {
    	
    	ServicoSibar servico = servicoRepository.findById(dto.getId());
    	servico.getKey().setNome(dto.getNome());
    	servico.getKey().setOperacao(dto.getOperacao());
    	servico.getKey().setOperacao(dto.getOperacao());
    	
    	servicoRepository.persist(servico);
    	return Response.ok(servico).build();

    }
    
    @DELETE
    @Transactional
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        return Response.ok(servicoRepository.deleteById(id)).build();
    }
    
}