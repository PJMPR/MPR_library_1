package library.dao.repos;

import java.util.List;

import library.domain.Book;

public interface IBookRepository extends IRepository<Book> {
	
	public List<Book> withTitle(String title);
	public List<Book> withPublisher(String publisher);
	public List<Book> withAvailability(boolean isAvailable);

}
