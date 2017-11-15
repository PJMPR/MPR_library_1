package library.daor.repos.examples;

import java.sql.Connection;
import java.sql.SQLException;

import library.dao.mappers.ReservationItemMapper;
import library.dao.repos.IDatabaseCatalog;
import library.dao.repos.impl.ReservationItemRepository;

public class ReservationItemRepositoryExample 
{
	
	public static void run(Connection connection, IDatabaseCatalog catalog) 
	{
		catalog.reservationItems().createTable();
	}

}
