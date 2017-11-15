package library.dao.uow;

import library.domain.IHaveId;

public class Entity {

	private EntityState state;
	private Object entity;
	private IUnitOfWorkRepository _repository;
	
	public Entity(IUnitOfWorkRepository repository){
		_repository=repository;
		this.state = EntityState.Unchanged;
		
	}
	
	public Object getEntity(){
		return entity;
	}
	
	public <TEntity extends IHaveId> void setEntity(TEntity entity){
		this.entity = entity;
	}

	public EntityState getState() {
		return state;
	}

	public void setState(EntityState state) {
		this.state = state;
	}
	
	public void persist(){
		switch (this.state) {
		case Changed:
			_repository.persistUpdate(this);
			break;
		case Deleted:
			_repository.persistDelete(this);
			break;
		case New:
			_repository.persistAdd(this);
			break;
		case Unchanged:
			break;
		case Unknown:
			break;
		default:
			break;}
	}
	
}
