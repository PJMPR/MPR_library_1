package library;

import static org.junit.Assert.*;

import org.junit.Test;

import library.domain.Book;
import library.domain.Person;
import library.domain.checkers.BookChecker;
import library.domain.checkers.PersonChecker;

public class book_checker_test {
	@Test
	public void check_test_if_book_has_name_Book_etc () {

		BookChecker checker = new BookChecker();
		
		Book BookNull = new Book();
		
		Book BookEmpty = new Book();
		
		Book BookWith = new Book();
		
		BookEmpty.setTitle("");
		BookEmpty.setPublisher("");
		BookEmpty.setYear(0);
		
		BookWith.setTitle("Przygoda z lwami");
		BookWith.setPublisher("Ostatnia przygoda");
		BookWith.setYear(1999);
		
		boolean inValidResultForNullTitle = checker.isTitleValid(BookNull);
		boolean inValidResultForEmptyTitle = checker.isPublisherValid(BookEmpty);
		boolean validResultTitle = checker.isYearValid(BookWith);
		
		boolean inValidResultForNullPublisher = checker.isTitleValid(BookNull);
		boolean inValidResultForEmptyPublisher = checker.isPublisherValid(BookEmpty);
		boolean validResultPublisher = checker.isYearValid(BookWith);
		
		boolean inValidResultForNullYear = checker.isTitleValid(BookNull);
		boolean inValidResultForEmptyYear = checker.isPublisherValid(BookEmpty);
		boolean validResultYear = checker.isYearValid(BookWith);
		
		assertFalse("check title failed", inValidResultForNullTitle);
		assertFalse(inValidResultForEmptyTitle);
		assertTrue(validResultTitle);
		
		assertFalse("check publisher failed", inValidResultForNullPublisher);
		assertFalse(inValidResultForEmptyPublisher);
		assertTrue(validResultPublisher);
		
		assertFalse("check year failed", inValidResultForNullYear);
		assertFalse(inValidResultForEmptyYear);
		assertTrue(validResultYear);
		
	}
}
