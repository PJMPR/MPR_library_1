package library.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import library.domain.ReservationItem;

public class ReservationItemMapper implements IMapper<ReservationItem> {

	@Override
	public ReservationItem map(ResultSet rs) throws SQLException {
		ReservationItem reservationItem = new ReservationItem();
		reservationItem.setId(rs.getInt("id"));
		reservationItem.setReservationId(rs.getInt("reservation_id"));
		reservationItem.setBookId(rs.getInt("book_id"));
		return reservationItem;
	}
	
}
