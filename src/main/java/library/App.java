package library;

import library.dao.repos.PersonRepository;

public class App 
{
    public static void main( String[] args )
    {
    	PersonRepository repository = new PersonRepository();
    	repository.createTable();
    	
        System.out.println( "koniec" );
    }
}
