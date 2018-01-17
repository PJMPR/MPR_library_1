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

import library.dao.repos.IUserRepository;
import library.domain.User;

@Path("/users")
@Stateless
public class UserResources {

	@PersistenceContext
	EntityManager mgr;
	
	IUserRepository _users;
	
	public UserResources() {}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUsers(){
		return 
				Response.ok(new GenericEntity<List<User>>(
				mgr.createNamedQuery("users.all", User.class).getResultList()){})
				.build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertUser(User user){
		mgr.persist(user);
		return Response.ok().build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("id") int id){
		User result = mgr.createNamedQuery("users.id", User.class)
				.setParameter("id", id)
				.getSingleResult();
		
		if(result == null)
			return Response.status(404).build();
		
		return Response.ok(result).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id){
		User result = mgr.createNamedQuery("users.id", User.class)
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
	public Response update(@PathParam("id") int id, User user){

		User result = mgr.createNamedQuery("users.id", User.class)
				.setParameter("id", id)
				.getSingleResult();
		if(result==null)
			return Response.status(404).build();
		result.setLogin(user.getLogin());
		result.setPassword(user.getPassword());
		result.setEmail(user.getEmail());
		mgr.persist(result);
		
		return Response.ok().build();
	}
	
}
