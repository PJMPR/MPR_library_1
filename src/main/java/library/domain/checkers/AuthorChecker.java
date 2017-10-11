package library.domain.checkers;

import library.domain.Author;
import library.domain.Person;

public class AuthorChecker {
	public boolean isNamestValid(Author author) {
		return author.getFirst_name()!=null && !author.getFirst_name().isEmpty();
	}
	public boolean isLastValid(Author author) {
		return author.getLast_name()!=null && !author.getLast_name().isEmpty();
	}
}
