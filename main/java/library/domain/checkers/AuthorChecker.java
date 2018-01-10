package library.domain.checkers;

import library.domain.Author;
import library.domain.Person;

public class AuthorChecker {
	public boolean isNamestValid(Author author) {
		return author.getFirstName()!=null && !author.getFirstName().isEmpty();
	}
	public boolean isLastValid(Author author) {
		return author.getLastName()!=null && !author.getLastName().isEmpty();
	}
}
