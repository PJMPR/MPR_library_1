package library.web.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Author> getAllAuthors(){
		return mgr.createNamedQuery("authors.all", Author.class).getResultList();
		
	}
	
	@GET
	@Path("/test")
	@Produces("text/html")
	public String test(){
		return "REST Service is running";
	}
	
}
