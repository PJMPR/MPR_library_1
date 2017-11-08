package library.dao.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class RepositoryBase {


	protected Connection connection;
	
	protected boolean tableExists;
	
	protected PreparedStatement insert;
	protected PreparedStatement selectById;
	protected PreparedStatement count;
	protected PreparedStatement lastId;
	protected PreparedStatement selectPage;
	protected PreparedStatement delete;
	protected PreparedStatement update;
	
	protected RepositoryBase(Connection connection){
		
		try {
			
			this.connection = connection;
			initStatements(connection);
			ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
			checkIfTableExists(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void checkIfTableExists(ResultSet rs) throws SQLException {
		while(rs.next()){
			if(rs.getString("TABLE_NAME").equalsIgnoreCase(getTableName()))
				tableExists=true;
		}
	}

	private void initStatements(Connection connection) throws SQLException {
		insert = connection.prepareStatement(getInsertQuerySql());
		selectById = connection.prepareStatement(""
				+ "SELECT * FROM "
				+ getTableName()
				+ " WHERE id=?");
		
		count = connection.prepareStatement("SELECT COUNT(*) FROM "+getTableName());
		lastId = connection.prepareStatement("SELECT MAX(id) FROM "+getTableName());
		selectPage = connection.prepareStatement( "SELECT * FROM "
				+ getTableName()
				+ " OFFSET ? LIMIT ?");
		
		delete = connection.prepareStatement("DELETE FROM "
				+ getTableName()
				+ " WHERE id=?");
		
		update = connection.prepareStatement(getUpdateQuerySql());
	}

	
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

	protected abstract String getUpdateQuerySql();
	protected abstract String getInsertQuerySql();
	protected abstract String getTableName();	
}
