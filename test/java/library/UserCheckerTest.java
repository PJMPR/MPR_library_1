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


public void test_checker_should_check_if_user_have_password() {
	
	UserChecker checker = new UserChecker();
	User userWithNullPassword = new User();
	User userWithEmptyPassword = new User();
	User  userWithPassword = new User();
	
	userWithEmptyPassword.setPassword("");
	userWithPassword.setPassword("a");
	
	boolean inValidResultForNull = checker.isPasswordValid(userWithNullPassword);
	boolean inValidResultForEmptyPassword = checker.isPasswordValid(userWithEmptyPassword);
	boolean validResult = checker.isPasswordValid(userWithPassword);
	
	
	assertFalse("check user password failed", inValidResultForNull);
	assertFalse(inValidResultForEmptyPassword);
	assertTrue(validResult);
	
}

public void test_checker_should_check_if_user_have_email() {
	
	UserChecker checker = new UserChecker();
	User userWithNullEmail = new User();
	User userWithEmptyEmail = new User();
	User  userWithEmail = new User();
	
	userWithEmptyEmail.setEmail("");
	userWithEmail.setEmail("a");
	
	boolean inValidResultForNull = checker.isEmailValid(userWithNullEmail);
	boolean inValidResultForEmptyEmail = checker.isEmailValid(userWithEmptyEmail);
	boolean validResult = checker.isEmailValid(userWithEmail);
	
	
	assertFalse("check user email failed", inValidResultForNull);
	assertFalse(inValidResultForEmptyEmail);
	assertTrue(validResult);
	
}
}