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
import library.domain.User;

public class App 
{
    public static void main( String[] args )
    {
    	PersonRepository repository = new PersonRepository();
    	repository.createTable();
    	
    	Person jan = repository.get(1);
    	
    	System.out.println(jan.getName() + " " + jan.getSurname()+" " +jan.getId());
    	
        System.out.println( "koniec" );
    }
}
