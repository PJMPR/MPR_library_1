package library.daor.repos.examples;

import java.sql.Connection;

import library.dao.repos.ReservationRepository;
import library.domain.Reservation;

public class ReservationRepositoryExample 
{
	
	public static void run(Connection connection)
	{
		ReservationRepository reservationRepository = new ReservationRepository();
		reservationRepository.createTable();
		
		Reservation reserv = new Reservation();
		reserv.setReservationDate(null);
		reserv.setRetirvalDate(null);
		reserv.setRealDate(null);
		
		reservationRepository.add(reserv);
	}

}
