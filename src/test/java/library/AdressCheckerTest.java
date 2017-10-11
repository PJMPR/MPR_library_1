package library;

import library.domain.Address;
import library.domain.checkers.AddressChecker;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AdressCheckerTest {

    AddressChecker checker = new AddressChecker();
    Address addressWithStreet = new Address();
    Address addressWithCity = new Address();
    Address addressWithCountry = new Address();
    Address addressWithHouseNumber = new Address();
    Address addressWithLocalNumber = new Address();
    Address addressWithPostCode = new Address();
    Address addressWithPhone = new Address();


    @Test
    public void test_checker_should_check_if_fields_are_fill() {

        addressWithStreet.setStreet("AAA");
        addressWithCity.setCity("BBB");
        addressWithCountry.setCountry("CCC");
        addressWithHouseNumber.setHouseNumber("12");
        addressWithLocalNumber.setLocalNumber("1234567");
        addressWithPostCode.setPostCode("12-345");
        addressWithPhone.setPhone("999999999");

        assertTrue(checker.isStreetValid(addressWithStreet));
        assertTrue(checker.isCityValid(addressWithCity));
        assertTrue(checker.isCountryValid(addressWithCountry));
        assertTrue(checker.isHouseNumberValid(addressWithHouseNumber));
        assertTrue(checker.isLocalNumberValid(addressWithLocalNumber));
        assertTrue(checker.isPostCodeValid(addressWithPostCode));
        assertTrue(checker.isPhoneValid(addressWithPhone));

    }
}
