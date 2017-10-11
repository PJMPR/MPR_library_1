package library;

import static org.junit.Assert.*;
import library.domain.Person;
import library.domain.checkers.PersonChecker;

import org.junit.Test;

public class PersonCheckerTest {

	@Test
	public void test_checker_should_check_if_person_has_name() {
		
		PersonChecker checker = new PersonChecker();
		Person personWithNullName = new Person();
		Person personWithEmptyName = new Person();
		Person personWithName = new Person();
		
		personWithEmptyName.setName("");
		personWithName.setName("a");
		
		boolean inValidResultForNull = checker.isNameValid(personWithNullName);
		boolean inValidResultForEmptyName = checker.isNameValid(personWithEmptyName);
		boolean validResult = checker.isNameValid(personWithName);
		
		
		assertFalse("check person name failed", inValidResultForNull);
		assertFalse(inValidResultForEmptyName);
		assertTrue(validResult);
		
	}

}
