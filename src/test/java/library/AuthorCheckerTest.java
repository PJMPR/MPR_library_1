package library;

import static org.junit.Assert.*;

import org.junit.Test;

import library.domain.Author;
import library.domain.Person;
import library.domain.checkers.AuthorChecker;
import library.domain.checkers.PersonChecker;

public class AuthorCheckerTest {
	@Test
	public void check_test_if_author_has_name_etc () {
		
		AuthorChecker checker = new AuthorChecker();
		
		Author authorWithNullFirstAndLast = new Author();
		
		Author authorWithEmptyFirstAndLast = new Author();
		
		Author authorWithFirstAndLast = new Author();
		
		authorWithEmptyFirstAndLast.setFirst_name("");
		authorWithEmptyFirstAndLast.setLast_name("");
		
		authorWithFirstAndLast.setFirst_name("Tomek");
		authorWithFirstAndLast.setLast_name("Pannowski");
		
		boolean inValidResultForNullFirst = checker.isNamestValid(authorWithNullFirstAndLast);
		boolean inValidResultForEmptyNameFirst = checker.isNamestValid(authorWithEmptyFirstAndLast);
		boolean validResultFirst = checker.isNamestValid(authorWithFirstAndLast);
		
		boolean inValidResultForNullLast = checker.isLastValid(authorWithNullFirstAndLast);
		boolean inValidResultForEmptyNameLast = checker.isLastValid(authorWithEmptyFirstAndLast);
		boolean validResultLast = checker.isLastValid(authorWithFirstAndLast);
		
		assertFalse("check person name failed", inValidResultForNullFirst);
		assertFalse(inValidResultForEmptyNameFirst);
		assertTrue(validResultFirst);
		
		assertFalse("check person name failed", inValidResultForNullLast);
		assertFalse(inValidResultForEmptyNameLast);
		assertTrue(validResultLast);
		
	}
}
