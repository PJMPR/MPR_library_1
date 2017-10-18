package library.dao.repos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BookRepository {
	
	String url = "jdbc:hsqldb:hsql://localhost/workdb";
	
	Connection connection;
	
	public BookRepository(){
		
		try {
			
			connection = DriverManager.getConnection(url);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void createTable(){
		
		String sql = "CREATE TABLE book("
				+ "id bigint GENERATED BY DEFAULT AS IDENTITY,"
				+ "title varchar(20),"
				+ "publisher varchar(50),"
				+ "year bigint,"
				+ "isAvailable boolean"
				+ ")";
		
		try {
			Statement createTable = connection.createStatement();
			createTable.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
