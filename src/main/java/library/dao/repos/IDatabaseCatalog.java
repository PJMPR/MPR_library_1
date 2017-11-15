package library.dao.repos;

import library.domain.Address;
import library.domain.Author;
import library.domain.Person;
import library.domain.Reservation;
import library.domain.ReservationItem;

public interface IDatabaseCatalog {

	public IRepository<Address> addresses();
	public IRepository<Person> people();
	public IRepository<Author> authors();
	public IRepository<ReservationItem> reservationItems();
	public IRepository<Reservation> reservation();
	
}
