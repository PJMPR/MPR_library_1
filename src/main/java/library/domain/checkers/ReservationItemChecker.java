package library.domain.checkers;

import library.domain.ReservationItem;

public class ReservationItemChecker {

	public boolean isBookNull(ReservationItem reservationItem){
		if(reservationItem.getBook()==null)
		{
			return false;
		}else {
			return true;
		}
	}
	public boolean isReservationNull(ReservationItem reservationItem){
		if(reservationItem.getReservation()==null)
		{
			return false;
		}else {
			return true;
		}
	}
}
