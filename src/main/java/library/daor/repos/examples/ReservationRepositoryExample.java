package library.daor.repos.examples;

import java.util.List;
import java.sql.Connection;

import library.dao.repos.IDatabaseCatalog;
import library.domain.Reservation;

public class ReservationRepositoryExample 
{
	
	public static void run(Connection connection, IDatabaseCatalog catalog) 
	{
		catalog.reservation().createTable();
		
		Reservation reserv = new Reservation();
		reserv.setReservationDate(null);
		reserv.setRetirvalDate(null);
		reserv.setRealDate(null);
		
		catalog.reservation().add(reserv);
		
		List<Reservation> reservwithdate = catalog.reservation().withReservationDate(null);
	}

}
