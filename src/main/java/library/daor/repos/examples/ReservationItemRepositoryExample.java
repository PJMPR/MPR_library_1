package library.daor.repos.examples;

import java.sql.Connection;

import library.dao.mappers.ReservationItemMapper;
import library.dao.repos.impl.ReservationItemRepository;

public class ReservationItemRepositoryExample 
{
	
	public static void run(Connection connection)
	{
		ReservationItemRepository reservationItemRepository = new ReservationItemRepository(connection, new ReservationItemMapper());
    	reservationItemRepository.createTable();
	}

}
