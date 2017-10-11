package library;



import static org.junit.Assert.*;
import library.domain.Book;
import library.domain.Reservation;
import library.domain.ReservationItem;
import library.domain.checkers.ReservationItemChecker;

import org.junit.Test;

public class ReservationItemCheckerTest {
	
	
	@Test
	public void test_checker_should_have_book()
	{
		ReservationItemChecker checker=new ReservationItemChecker();
		ReservationItem reservationItemNullBookReservation= new ReservationItem();
		reservationItemNullBookReservation.setBook(null);
		reservationItemNullBookReservation.setReservation(null);
		ReservationItem rs= new ReservationItem();
		rs.setBook(new Book());
		rs.setReservation(new Reservation());
		
		boolean invalidBook=checker.isBookNull(reservationItemNullBookReservation);
		boolean invalidReservation=checker.isReservationNull(reservationItemNullBookReservation);
		boolean validReservationItemBook=checker.isBookNull(rs);
		boolean validReservationItemReservation=checker.isReservationNull(rs);
		
		assertFalse(invalidBook);
		assertFalse(invalidReservation);
		assertTrue(validReservationItemBook);
		assertTrue(validReservationItemReservation);
		
		
	}
}
