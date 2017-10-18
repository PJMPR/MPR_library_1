package library;

import library.dao.repos.AuthorRepository;
import library.dao.repos.BookRepository;
import library.dao.repos.AddressRepository;
import library.dao.repos.PersonRepository;
import library.dao.repos.ReservationItemRepository;
import library.dao.repos.ReservationRepository;
import library.dao.repos.UserRepository;
import library.domain.Person;

public class App 
{
    public static void main( String[] args )
    {
    	PersonRepository repository = new PersonRepository();
    	repository.createTable();
    	
    	Person jan = new Person();
    	jan.setName("jan");
    	jan.setSurname("Kowalski");
    	
    	repository.add(jan);
    	
    	
    	
    	ReservationRepository reservationRepository = new ReservationRepository();
    	reservationRepository.createTable();
    	
    	ReservationItemRepository reservationItemRepository = new ReservationItemRepository();
    	reservationItemRepository.createTable();
    	
    	BookRepository bookRepository = new BookRepository();
    	bookRepository.createTable();
    	
    	AuthorRepository authorRepository = new AuthorRepository();
    	authorRepository.createTable();
    	AddressRepository repositoryAdderess = new AddressRepository();
    	repository.createTable();
    	
    	UserRepository repositoryUser = new UserRepository();
    	repository.createTable();
    	
        System.out.println( "koniec" );
    }
}
