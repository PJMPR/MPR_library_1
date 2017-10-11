package library.domain.checkers;

import library.domain.Person;

public class UserChecker {

    public boolean isLoginValid(User user) {
        return user.getLogin()!=null && !user.getLogin().isEmpty();
    }

}
