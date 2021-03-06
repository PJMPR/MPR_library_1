package library.dao.repos.impl;

import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import library.dao.mappers.IMapper;
import library.dao.repos.IReservationRepository;
import library.dao.uow.IUnitOfWork;
import library.domain.Reservation;

public class ReservationRepository extends RepositoryBase<Reservation> implements IReservationRepository {
	
	String selectByReservationDateSql = "SELECT * FROM reservation WHERE reservation_date=?";
	PreparedStatement selectByReservationDate;
	
	String selectByRetrievalDateSql = "SELECT * FROM reservation WHERE retrieval_date=?";
	PreparedStatement selectByRetrievalDate;
	
	public ReservationRepository(Connection connection, IMapper<Reservation> mapper, IUnitOfWork uow) throws SQLException
	{
		super(connection, mapper, uow);
		selectByReservationDate = connection.prepareStatement(selectByReservationDateSql);
		selectByRetrievalDate = connection.prepareStatement(selectByRetrievalDateSql);
	}
	
	@Override
	protected String getUpdateQuerySql() {
		return "UPDATE reservation SET (reservation_date, retrieval_date, real_date) = (?,?,?) WHERE id=?";
	}

	@Override
	protected String getInsertQuerySql() {
		return "INSERT INTO reservation (reservation_date, retrieval_date, real_date) VALUES (?,?,?)";
	}

	@Override
	protected String getTableName() {
		return "reservation";
	}

	@Override
	protected String createTableStatementSql() {
		return "CREATE TABLE reservation("
				+ "id bigint GENERATED BY DEFAULT AS IDENTITY,"
				+ "reservation_date date,"
				+ "retrieval_date date,"
				+ "real_date date"
				+ ")";
	}

	@Override
	protected void setUpdate(Reservation reservation) throws SQLException {
		update.setDate(1, reservation.getReservationDate());
		update.setDate(2, reservation.getRetirvalDate());
		update.setDate(3, reservation.getRealDate());
		update.setInt(4, reservation.getId());
	}

	@Override
	protected void setInsert(Reservation reservation) throws SQLException {
		insert.setDate(1, reservation.getReservationDate());
		insert.setDate(2, reservation.getRetirvalDate());
		insert.setDate(3, reservation.getRealDate());
	}
	
	@Override
	public List<Reservation> withReservationDate(Date ReservationDate) {
		List<Reservation> result = new ArrayList<Reservation>();
		try {
			selectByReservationDate.setDate(1, ReservationDate);
			ResultSet rs = selectByReservationDate.executeQuery();
			while(rs.next()) result.add(mapper.map(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<Reservation> withRetrievalDate(Date RetrievalDate) {
		List<Reservation> result = new ArrayList<Reservation>();
		try {
			selectByRetrievalDate.setDate(1, RetrievalDate);
			ResultSet rs = selectByRetrievalDate.executeQuery();
			while(rs.next()) result.add(mapper.map(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
