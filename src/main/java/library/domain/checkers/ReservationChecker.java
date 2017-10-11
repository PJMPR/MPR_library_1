package library.domain.checkers;

import java.util.Date;

import library.domain.Reservation;

public class ReservationChecker {

	public boolean isReservationDateNull(Reservation reservation){
		if(reservation.getReservationDate()==null)
		{
			return false;
		}else {
			return true;
		}
	}
	public boolean isRetrievalDateNull(Reservation reservation){
		if(reservation.getRetrievalDate()==null)
		{
			return false;
		}else {
			return true;
		}	
	}
	public boolean isRealDateNull(Reservation reservation){
		if(reservation.getRealDate()==null)
		{
			return false;
		}else {
			return true;
		}
	}
}
