package library.dao.repos.impl;

import java.sql.Connection;
import java.sql.SQLException;

import library.dao.mappers.IMapper;
import library.domain.ReservationItem;

public class ReservationItemRepository extends RepositoryBase<ReservationItem> 
{
	
	public ReservationItemRepository(Connection connection, IMapper<ReservationItem> mapper) throws SQLException 
	{
		super(connection, mapper);
	}
	
	@Override
	protected String getUpdateQuerySql() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected String getInsertQuerySql() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected String getTableName() {
		return "reservation_item";
	}

	@Override
	protected String createTableStatementSql() {
		return "CREATE TABLE reservation_item("
				+ "id bigint GENERATED BY DEFAULT AS IDENTITY,"
				+ "reservation_id bigint,"
				+ "book_id bigint"
				+ ")";
	}

	@Override
	protected void setUpdate(ReservationItem reservationItem) throws SQLException {
		update.setInt(1, reservationItem.getReservationId());
		update.setInt(2, reservationItem.getBookId());
		update.setInt(3, reservationItem.getId());
	}

	@Override
	protected void setInsert(ReservationItem reservationItem) throws SQLException {
		insert.setInt(1, reservationItem.getReservation().getId());
		insert.setInt(2, reservationItem.getBook().getId());
	}
	
}
