package library.daor.repos.examples;

import java.sql.Connection;

import library.dao.repos.ReservationItemRepository;

public class ReservationItemRepositoryExample 
{
	
	public static void run(Connection connection)
	{
		ReservationItemRepository reservationItemRepository = new ReservationItemRepository(connection);
    	reservationItemRepository.createTable();
	}

}
