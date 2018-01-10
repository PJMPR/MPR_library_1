package library.domain.checkers;

import library.domain.Book;


public class BookChecker {
	public boolean isTitleValid(Book book) {
		return book.getTitle()!=null && !book.getTitle().isEmpty();
	}
	public boolean isPublisherValid(Book book) {
		return book.getPublisher()!=null && !book.getPublisher().isEmpty();
	}
	public boolean isYearValid(Book book) {
		return book.getYear()!=0 && !(book.getYear()==0);
	}
	
}
