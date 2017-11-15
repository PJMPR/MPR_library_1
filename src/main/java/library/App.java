package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import library.dao.repos.IDatabaseCatalog;
import library.dao.repos.impl.DatabaseCatalog;
import library.daor.repos.examples.AddressRepositoryExample;
import library.daor.repos.examples.AuthorRepositoryExample;
import library.daor.repos.examples.BookRepositoryExample;
import library.daor.repos.examples.PersonRepositoryExample;
import library.daor.repos.examples.ReservationItemRepositoryExample;
import library.daor.repos.examples.ReservationRepositoryExample;
import library.daor.repos.examples.UserRepositoryExample;

public class App 
{
    public static void main( String[] args ) throws SQLException
    {

    	String url = "jdbc:hsqldb:hsql://localhost/workdb";
    	
    	Connection connection = DriverManager.getConnection(url);
    	IDatabaseCatalog catalog = new DatabaseCatalog(connection);
    	
    	PersonRepositoryExample.run(connection,catalog);
    	BookRepositoryExample.run(connection);
    	ReservationRepositoryExample.run(connection);
    	ReservationItemRepositoryExample.run(connection);
		AuthorRepositoryExample.run(connection);
		AddressRepositoryExample.run(connection);
    	UserRepositoryExample.run(connection);
        
        connection.close();
    }
}
