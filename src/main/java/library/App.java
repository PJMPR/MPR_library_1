package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import library.dao.repos.IDatabaseCatalog;
import library.dao.repos.impl.DatabaseCatalog;
import library.dao.uow.IUnitOfWork;
import library.dao.uow.UnitOfWork;
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
    	IUnitOfWork uow = new UnitOfWork(connection);
    	
    	IDatabaseCatalog catalog = new DatabaseCatalog(connection, uow);
    	
    	//PersonRepositoryExample.run(connection,catalog);
    	
    	BookRepositoryExample.run(connection, catalog);
    	ReservationRepositoryExample.run(connection,catalog);
    	ReservationItemRepositoryExample.run(connection,catalog);
		//AuthorRepositoryExample.run(connection, catalog);
		//AddressRepositoryExample.run(connection, catalog);
    	//UserRepositoryExample.run(connection, catalog);
    	
    	uow.saveChanges();
        connection.close();
    }
}
