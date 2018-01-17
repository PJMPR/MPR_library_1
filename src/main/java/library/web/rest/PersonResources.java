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

import library.dao.repos.IPersonRepository;
import library.domain.Person;

@Path("/persons")
@Stateless
public class PersonResources {

	@PersistenceContext
	EntityManager mgr;
	
	IPersonRepository _perons;
	
	public PersonResources() {}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPersons(){
		return 
				Response.ok(new GenericEntity<List<Person>>(
				mgr.createNamedQuery("persons.all", Person.class).getResultList()){})
				.build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertPerson(Person person){
		mgr.persist(person);
		return Response.ok().build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPerson(@PathParam("id") int id){
		Person result = mgr.createNamedQuery("persons.id", Person.class)
				.setParameter("id", id)
				.getSingleResult();
		
		if(result == null)
			return Response.status(404).build();
		
		return Response.ok(result).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id){
		Person result = mgr.createNamedQuery("persons.id", Person.class)
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
	public Response update(@PathParam("id") int id, Person person){

		Person result = mgr.createNamedQuery("persons.id", Person.class)
				.setParameter("id", id)
				.getSingleResult();
		if(result==null)
			return Response.status(404).build();
		result.setName(person.getName());
		result.setSurname(person.getSurname());
		mgr.persist(result);
		
		return Response.ok().build();
	}
	
}
