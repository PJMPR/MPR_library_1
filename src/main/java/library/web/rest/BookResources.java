package library.web.rest;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.websocket.server.PathParam;
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
import library.domain.Book;

@Path("/books")
@Stateless
public class BookResources {

	@PersistenceContext
	EntityManager mgr;
	
	IAuthorRepository _books;
	
	public BookResources(){
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllAuthors(){
		return 
				Response.ok(new GenericEntity<List<Book>>(
				mgr.createNamedQuery("books.all", Book.class).getResultList()){
					
				})
				.build();
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertBook(Book book){
		mgr.persist(book);
		return Response.ok().build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBook(@PathParam("id") int id){
		Book result = mgr.createNamedQuery("books.id", Book.class)
				.setParameter("id", id)
				.getSingleResult();
		
		if(result == null)
			return Response.status(404).build();
		
		return Response.ok(result).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id){
		Book result = mgr.createNamedQuery("books.id", Book.class)
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
	public Response update(@PathParam("id") int id, Book book){

		Book result = mgr.createNamedQuery("books.id", Book.class)
				.setParameter("id", id)
				.getSingleResult();
		if(result==null)
			return Response.status(404).build();
		result.setTitle(book.getTitle());
		result.setPublisher(book.getPublisher());
		result.setYear(book.getYear());
		result.setAuthors(book.getAuthors());
		result.setAvailable(book.isAvailable());
		mgr.persist(result);
		
		return Response.ok().build();
	}
	
}