package library.dao.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositoryBase {


	protected Connection connection;
	
	protected boolean tableExists;
	
	protected PreparedStatement insert;
	protected PreparedStatement selectById;
	protected PreparedStatement count;
	protected PreparedStatement lastId;
	protected PreparedStatement selectPage;
	protected PreparedStatement delete;
	protected PreparedStatement update;
	
	public int count(){
		try {
			ResultSet rs = count.executeQuery();
			while(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int lastId(){try {
		ResultSet rs = lastId.executeQuery();
		while(rs.next()){
			return rs.getInt(1);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return 0;
	}
	
}
