package library.web.rest;

import java.util.List;

import javax.ejb.Stateless;
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

	IAuthorRepository _authors;
	
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Author> getAllAuthors(){
		return _authors.getPage(1, 10);
		
	}
	
	@GET
	@Path("/test")
	@Produces("text/html")
	public String test(){
		return "REST Service is running";
	}
	
}
