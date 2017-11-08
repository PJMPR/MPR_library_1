package library.dao.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import library.domain.IHaveId;
import library.domain.Person;

public abstract class RepositoryBase<TEntity extends IHaveId> {


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
	

	public void delete(TEntity person){
		
		try {
			delete.setInt(1, person.getId());
			delete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public void createTable(){
		
		String sql = createTableStatementSql();
		
		try {
			Statement createTable = connection.createStatement();
			if(!tableExists)
				createTable.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected abstract String createTableStatementSql();
	protected abstract String getUpdateQuerySql();
	protected abstract String getInsertQuerySql();
	protected abstract String getTableName();	
}
