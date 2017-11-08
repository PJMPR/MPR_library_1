package library.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import library.domain.Reservation;

public class ReservationMapper implements IMapper<Reservation> {

	@Override
	public Reservation map(ResultSet rs) throws SQLException {
		Reservation reservation = new Reservation();
		reservation.setId(rs.getInt("id"));
		reservation.setReservationDate(rs.getDate("reservation_date"));
		reservation.setRetirvalDate(rs.getDate("retrival_date"));
		reservation.setRealDate(rs.getDate("real_date"));
		return reservation;
	}
	
}
