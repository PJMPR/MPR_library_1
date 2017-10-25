package library;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import library.domain.Reservation;
import library.domain.checkers.ReservationChecker;

import org.junit.Test;

public class ReservationCheckerTest {

	@Test
	public void test_checker_should_has_date(){
		Reservation reservation = new Reservation();
		reservation.setReservationDate(null);
		reservation.setRetrievalDate(null);
		reservation.setRealDate(null);
		
		Reservation greatReservation = new Reservation();
		Date date=new Date();
		greatReservation.setReservationDate(date);
		greatReservation.setRetrievalDate(date);
		greatReservation.setRealDate(date);
		
	
		ReservationChecker checker = new ReservationChecker();
		
		boolean invalidReservationDate = checker.isReservationDateNull(reservation);
		boolean invalidRetrievalDate = checker.isRetrievalDateNull(reservation);
		boolean invalidRealDate = checker.isRealDateNull(reservation);
		
		boolean validReservationDate = checker.isReservationDateNull(greatReservation);
		boolean validRetrievalDate = checker.isRetrievalDateNull(greatReservation);
		boolean validRealDate = checker.isRealDateNull(greatReservation);
		
		assertFalse(invalidReservationDate);
		assertFalse(invalidRetrievalDate);
		assertFalse(invalidRealDate);
		assertTrue(validReservationDate);
		assertTrue(validRetrievalDate);
		assertTrue(validRealDate);
	}
	
}
