package library.dao.repos.impl;

import java.sql.Connection;
import java.sql.DriverManager;

import library.dao.repos.IDatabaseCatalog;
import library.dao.repos.IDbCatalogfactory;
import library.dao.uow.IUnitOfWork;
import library.dao.uow.UnitOfWork;

public class HsqlDbCatalogFactory implements IDbCatalogfactory{

	@Override
	public IDatabaseCatalog library() {

    	String url = "jdbc:hsqldb:hsql://localhost/workdb";
    	IDatabaseCatalog catalog;
		try {		
			Class.forName("org.hsqldb.jdbcDriver");
	    	Connection connection = DriverManager.getConnection(url);
	    	IUnitOfWork uow = new UnitOfWork(connection);
			catalog = new DatabaseCatalog(connection, uow);
			return catalog;
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

}
