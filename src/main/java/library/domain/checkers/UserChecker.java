package library.domain.checkers;

import library.domain.User;

public class UserChecker {

	public boolean isLoginValid(User user) {
		return user.getLogin()!=null && !user.getLogin().isEmpty();
	}
	public boolean isPasswordValid(User user) {
		return user.getPassword()!=null && !user.getPassword().isEmpty();
	}
	public boolean isEmailValid(User user) {
		return user.getEmail()!=null && !user.getEmail().isEmpty();
	}
}
