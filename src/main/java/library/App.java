package library;

import library.dao.repos.AuthorRepository;
import library.dao.repos.BookRepository;
import library.dao.repos.AddressRepository;
import library.dao.repos.PersonRepository;
import library.dao.repos.ReservationItemRepository;
import library.dao.repos.ReservationRepository;
import library.dao.repos.UserRepository;
import library.domain.Address;
import library.domain.Author;
import library.domain.Book;
import library.domain.Person;
import library.domain.Reservation;
import library.domain.ReservationItem;
import library.domain.User;

public class App 
{
    public static void main( String[] args )
    {
    	PersonRepository repository = new PersonRepository();
    	repository.createTable();
    	
    	Person jan = repository.get(1);
    	
    	repository.add(jan);
    	
    	ReservationRepository reservationRepository = new ReservationRepository();
    	reservationRepository.createTable();
    	
    	Reservation reserv = new Reservation();
    	reserv.setReservationDate(null);
    	reserv.setRetirvalDate(null);
    	reserv.setRealDate(null);
    	
    	reservationRepository.add(reserv);
    	
    	ReservationItemRepository reservationItemRepository = new ReservationItemRepository();
    	reservationItemRepository.createTable();
    	
    	
    	BookRepository bookRepository = new BookRepository();
    	bookRepository.createTable();
    	
    	AuthorRepository authorRepository = new AuthorRepository();
    	authorRepository.createTable();
    	
    	AddressRepository addressRepository = new AddressRepository();
    	addressRepository.createTable();
    	
    	Address address = new Address();
    	address.setStreet("ABC");
    	address.setPostCode("CDF");
    	address.setPhone("123-456-789");
    	address.setLocalNumber("678");
    	address.setCountry("ASGAS");
    	address.setHouseNumber("346");
    	address.setCity("adgasdg");
    	
    	addressRepository.add(address);
    	
    	int lastId = addressRepository.lastId();
    	int count = addressRepository.count();
    	
    	System.out.println(lastId + " " + count);
    	
    	UserRepository repositoryUser = new UserRepository();
    	repository.createTable();
    	System.out.println(jan.getName() + " " + jan.getSurname()+" " +jan.getId());
        System.out.println( "koniec" );
    }
}
