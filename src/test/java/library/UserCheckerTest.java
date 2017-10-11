package library;


import static org.junit.Assert.*;

import org.junit.Test;

import library.domain.User;
import library.domain.checkers.UserChecker;

public class UserCheckerTest {

	@Test
	public void test_checker_should_check_if_user_have_login() {
		
		UserChecker checker = new UserChecker();
		User userWithNullLogin = new User();
		User userWithEmptyLogin = new User();
		User  userWithLogin = new User();
		
		userWithEmptyLogin.setLogin("");
		userWithLogin.setLogin("a");
		
		boolean inValidResultForNull = checker.isLoginValid(userWithNullLogin);
		boolean inValidResultForEmptyLogin = checker.isLoginValid(userWithEmptyLogin);
		boolean validResult = checker.isLoginValid(userWithLogin);
		
		
		assertFalse("check user login failed", inValidResultForNull);
		assertFalse(inValidResultForEmptyLogin);
		assertTrue(validResult);
		
	}

}
