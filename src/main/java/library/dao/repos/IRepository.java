package library.dao.repos;

import java.util.List;

import library.domain.IHaveId;

public interface IRepository<TEntity extends IHaveId> {

	public void add(TEntity person);
	public List<TEntity> getPage(int offset, int limit);
	public TEntity get(int id);
	public void update(TEntity person);
	public void delete(TEntity person);
	public int count();
	public int lastId();
	public void createTable();
}
