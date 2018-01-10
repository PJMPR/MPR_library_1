package library.daor.repos.examples;

import java.sql.Connection;

import library.dao.repos.IDatabaseCatalog;
import library.domain.ReservationItem;


public class ReservationItemRepositoryExample 
{
	
	public static void run(Connection connection, IDatabaseCatalog catalog) 
	{
		catalog.reservationItems().createTable();
		
		ReservationItem item = new ReservationItem();
		item.setReservationId(1);
		item.setBookId(12);
		
		catalog.reservationItems().add(item);
	}

}
