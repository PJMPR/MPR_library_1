package library.dao.repos;

import library.domain.Address;
import library.domain.Author;
import library.domain.Reservation;
import library.domain.ReservationItem;
import library.domain.User;

public interface IDatabaseCatalog {

	public IAddressRepository addresses();
	public IPersonRepository people();
	public IRepository<Author> authors();
	public IBookRepository books();
	public IAuthorRepository authors();
	public IRepository<Book> books();
	public IRepository<ReservationItem> reservationItems();
	public IReservationRepository reservation();
	public IRepository<User> users();
}
