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

import br.org.caixa.api.model.FilaDto;
import br.org.caixa.persistencia.entidade.Fila;
import br.org.caixa.persistencia.repository.FilaRepository;

@Path("/fila")
public class FilaResource {

	@Inject
	FilaRepository filaRepository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getList() {
		return Response.ok(filaRepository.findAll().list()).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id) {
        return Response.ok(filaRepository.findById(id)).build();
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
    
}