package library.daor.repos.examples;

import java.sql.Connection;

import library.dao.repos.AddressRepository;
import library.dao.repos.PersonRepository;
import library.domain.Address;
import library.domain.Person;

public class AddressRepositoryExample {
	public static void run(Connection connection){
		
    	AddressRepository repository = new AddressRepository(connection);
    	repository.createTable();
    	
    	Address address = new Address();
    	address.setStreet("Szybka");
    	address.setCity("Gdansk");
    	address.setPostCode("84-555");
    	address.setCountry("Polska");
    	address.setHouseNumber("23");
    	address.setLocalNumber("3");
    	address.setPhone("664-000-444");
    	
    	
    	repository.add(address);
    	
    	int lastId = repository.lastId();
    	int count = repository.count();
    	
    	System.out.println(lastId + " " +  count);
		
	}
}
