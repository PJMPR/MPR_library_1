package library.dao.repos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import library.dao.mappers.IMapper;
import library.dao.repos.IRepository;
import library.dao.uow.Entity;
import library.dao.uow.IUnitOfWork;
import library.dao.uow.IUnitOfWorkRepository;
import library.domain.IHaveId;

public abstract class RepositoryBase<TEntity extends IHaveId> 
	implements IRepository<TEntity>, IUnitOfWorkRepository {


	protected Connection connection;
	protected IMapper<TEntity> mapper;
	
	protected boolean tableExists;
	
	protected PreparedStatement insert;
	protected PreparedStatement selectById;
	protected PreparedStatement count;
	protected PreparedStatement lastId;
	protected PreparedStatement selectPage;
	protected PreparedStatement delete;
	protected PreparedStatement update;
	
	protected IUnitOfWork uow;
	
	protected RepositoryBase(Connection connection, IMapper<TEntity> mapper, IUnitOfWork uow) throws SQLException{
		this.mapper = mapper;
		this.connection = connection;
		ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
		checkIfTableExists(rs);
		if(!tableExists){
			createTable();
			uow.saveChanges();
		}
		initStatements(connection);
		this.uow = uow;
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
	

	public void delete(TEntity entity){
		
		Entity ent = new Entity(this);
		ent.setEntity(entity);
		uow.markAsDeleted(ent);
		
	}
	
	public void update(TEntity entity){

		Entity ent = new Entity(this);
		ent.setEntity(entity);
		uow.markAsChanged(ent);
	}

	public void add(TEntity entity){

		Entity ent = new Entity(this);
		ent.setEntity(entity);
		uow.markAsNew(ent);
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
	

	public List<TEntity> getPage(int offset, int limit){
		List<TEntity> result = new ArrayList<TEntity>();
		try {
			selectPage.setInt(1, offset);
			selectPage.setInt(1, limit);
			ResultSet rs = selectPage.executeQuery();
			while(rs.next()){
				result.add(mapper.map(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public TEntity get(int id){
		
		try {
			selectById.setInt(1, id);
			ResultSet rs = selectById.executeQuery();
			
			while(rs.next()){
				return mapper.map(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	

	public void persistAdd(Entity entity){
		try {
			setInsert((TEntity)entity.getEntity());
			insert.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void persistUpdate(Entity entity){
		try {
			setUpdate((TEntity)entity.getEntity());
			update.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void persistDelete(Entity entity){
		try {
			delete.setInt(1, ((TEntity)entity.getEntity()).getId());
			delete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected abstract String createTableStatementSql();
	protected abstract String getUpdateQuerySql();
	protected abstract String getInsertQuerySql();
	protected abstract String getTableName();	
	
	protected abstract void setUpdate(TEntity person) throws SQLException;
	protected abstract void setInsert(TEntity person) throws SQLException;
}
