package library;

import static org.junit.Assert.*;
import library.domain.Person;
import library.domain.checkers.PersonChecker;

import org.junit.Test;

public class UserCheckerTest {

    @Test
    public void test_checker_should_check_if_person_has_login() {

        UserChecker checker = new UserChecker();
        User userWithNullLogin = new User();
        User userWithEmptyPassword = new User();
        User userWithEmail = new User();

        userWithNullLogin.setLogin("");
        userWithEmptyPassword.setPassword("");
        usernWithEmail.setEmail("a");

        boolean inValidResultForNull = checker.isLoginValid(userWithNullLogin);
        boolean inValidResultForEmptyPassword = checker.isPasswordValid(userWithEmptyPassword);
        boolean validResult = checker.isEmailValid(userWithEmail);


        assertFalse("check user login failed", inValidResultForNull);
        assertFalse(inValidResultForEmptyName);
        assertTrue(validResult);

    }

}
