package library;

import library.dao.repos.PersonRepository;
import library.dao.repos.ReservationItemRepository;
import library.dao.repos.ReservationRepository;

public class App 
{
    public static void main( String[] args )
    {
    	PersonRepository repository = new PersonRepository();
    	repository.createTable();
    	
    	ReservationRepository reservation_repository = new ReservationRepository();
    	reservation_repository.createTable();
    	
    	ReservationItemRepository reservation_item_repository = new ReservationItemRepository();
    	reservation_item_repository.createTable();
    	
        System.out.println( "koniec" );
    }
}
