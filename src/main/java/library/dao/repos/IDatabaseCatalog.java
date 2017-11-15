package library.dao.repos;

import library.domain.Address;
import library.domain.Author;
import library.domain.Reservation;
import library.domain.ReservationItem;
import library.domain.User;

public interface IDatabaseCatalog {

	public IRepository<Address> addresses();
	public IPersonRepository people();
	public IRepository<Author> authors();
	public IBookRepository books();
	public IRepository<ReservationItem> reservationItems();
	public IRepository<Reservation> reservation();
	public IRepository<User> users();
}
