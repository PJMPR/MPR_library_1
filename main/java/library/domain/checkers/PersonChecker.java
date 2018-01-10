package library.domain.checkers;

import library.domain.Person;

public class PersonChecker {

	public boolean isNameValid(Person person) {
		return person.getName()!=null && !person.getName().isEmpty();
	}

}
