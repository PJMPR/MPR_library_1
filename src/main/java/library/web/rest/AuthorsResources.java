package library.web.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.mail.imap.protocol.Status;

import library.dao.repos.IAuthorRepository;
import library.dao.repos.impl.HsqlDbCatalogFactory;
import library.domain.Author;

@Path("/authors")
@Stateless
public class AuthorsResources {

	@PersistenceContext
	EntityManager mgr;
	
	IAuthorRepository _authors;
	
	public AuthorsResources(){
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllAuthors(){
		return 
				Response.ok(new GenericEntity<List<Author>>(
				mgr.createNamedQuery("authors.all", Author.class).getResultList()){
					
				})
				.build();
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertAuthor(Author author){
		mgr.persist(author);
		return Response.ok().build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAuthor(@PathParam("id") int id){
		Author result = mgr.createNamedQuery("authors.id", Author.class)
				.setParameter("id", id)
				.getSingleResult();
		
		if(result == null)
			return Response.status(404).build();
		
		return Response.ok(result).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id){
		Author result = mgr.createNamedQuery("authors.id", Author.class)
				.setParameter("id", id)
				.getSingleResult();
		if(result==null)
			return Response.status(404).build();
		mgr.remove(result);
		return Response.ok().build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, Author author){

		Author result = mgr.createNamedQuery("authors.id", Author.class)
				.setParameter("id", id)
				.getSingleResult();
		if(result==null)
			return Response.status(404).build();
		result.setFirstName(author.getFirstName());
		result.setLastName(author.getLastName());
		mgr.persist(result);
		
		return Response.ok().build();
	}
	
}
