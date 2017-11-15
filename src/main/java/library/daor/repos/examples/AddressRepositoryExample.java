package library.daor.repos.examples;

import java.sql.Connection;
import java.util.List;

import library.dao.mappers.AddressMapper;
import library.dao.mappers.AuthorMapper;
import library.dao.repos.IDatabaseCatalog;
import library.dao.repos.impl.AddressRepository;
import library.dao.repos.impl.PersonRepository;
import library.domain.Address;
import library.domain.Person;

public class AddressRepositoryExample {
	public static void run(Connection connection,IDatabaseCatalog catalog){
		
    	catalog.addresses().createTable();
    	
    	Address address = new Address();
    	address.setStreet("Szybka");
    	address.setCity("Gdansk");
    	address.setPostCode("84-555");
    	address.setCountry("Polska");
    	address.setHouseNumber("23");
    	address.setLocalNumber("3");
    	address.setPhone("664-000-444");
    	
    	catalog.addresses().add(address);
    	
    	int lastId = catalog.addresses().lastId();
    	int count = catalog.addresses().count();
    	
    	List<Address> postCodeTest = catalog.addresses().withPostCode("84-555");
    	List<Address> cityTest = catalog.addresses().withCity("Gdansk");
    	System.out.println(lastId + " " +  count);
		
	}
}
