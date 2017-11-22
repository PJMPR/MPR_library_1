package library.dao.repos;

import java.sql.Date;
import java.util.List;

import library.domain.Reservation;

public interface IReservationRepository extends IRepository<Reservation>{

	List<Reservation> withReservationDate(Date ReservationDate);

	List<Reservation> withRetrievalDate(Date RetrievalDate);

}

