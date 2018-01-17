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
import library.dao.repos.IAddressRepository;
import library.domain.Address;

@Path("/address")
@Stateless
public class AdressResources {
	
	@PersistenceContext
	EntityManager mgr;
	
	IAddressRepository _address;
	
	public AdressResources(){
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllAdresses(){
		return 
				Response.ok(new GenericEntity<List<Address>>(
				mgr.createNamedQuery("address.all", Address.class).getResultList()){
					
				})
				.build();
		
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertAddress(Address address){
		mgr.persist(address);
		return Response.ok().build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAddress(@PathParam("id") int id){
		Address result = mgr.createNamedQuery("address.id", Address.class)
				.setParameter("id", id)
				.getSingleResult();
		
		if(result == null)
			return Response.status(404).build();
		
		return Response.ok(result).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id){
		Address result = mgr.createNamedQuery("address.id", Address.class)
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
	public Response update(@PathParam("id") int id, Address address){

		Address result = mgr.createNamedQuery("address.id", Address.class)
				.setParameter("id", id)
				.getSingleResult();
		if(result==null)
			return Response.status(404).build();
		result.setStreet(address.getStreet());
		mgr.persist(result);
		
		return Response.ok().build();
	}
	
	
	
	
	
}
