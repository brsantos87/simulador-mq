package br.org.caixa.api;

import javax.inject.Inject;
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

import br.org.caixa.persistencia.entidade.Fila;
import br.org.caixa.persistencia.repository.FilaRepository;

@Path("/fila")
public class FilaResource {

	@Inject
	FilaRepository filaRepository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarTodos() {
		return Response.ok(filaRepository.findAll()).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
    public Response buscar(@PathParam("id") Long id) {
        return Response.ok(filaRepository.findById(id)).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Response criar(Fila fila) {
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
    public Response atualizar() {
 
        return Response.ok().build();

    }
    
    @DELETE
    @Path("teste")
    public Response apagar() {
        return Response.ok().build();

    }
}