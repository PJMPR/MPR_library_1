package library;

import library.domain.Address;
import library.domain.checkers.AddressChecker;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdressCheckerTest {

    AddressChecker addressChecker = new AddressChecker();
    Address addresStreet = new Address();
    Address addressCity = new Address();
    Address addressCountry = new Address();
    Address addressHouseNumber = new Address();
    Address addressLocalNumber = new Address();
    Address addressPostCode = new Address();
    Address addressPhone = new Address();


    @Test
    public void test_checker_should_check_if_fields_are_fill() {

        addresStreet.setStreet("AAA");
        addressCity.setCity("BBB");
        addressCountry.setCountry("CCC");
        addressHouseNumber.setHouseNumber("12");
        addressLocalNumber.setLocalNumber("1234567");
        addressPostCode.setPostCode("12-345");
        addressPhone.setPhone("999999999");

        assertTrue(addressChecker.isStreetValid(addresStreet));
        assertTrue(addressChecker.isCityValid(addressCity));
        assertTrue(addressChecker.isCountryValid(addressCountry));
        assertTrue(addressChecker.isHouseNumberValid(addressHouseNumber));
        assertTrue(addressChecker.isLocalNumberValid(addressLocalNumber));
        assertTrue(addressChecker.isPostCodeValid(addressPostCode));
        assertTrue(addressChecker.isPhoneValid(addressPhone));

        addresStreet.setStreet("");
        addressCity.setCity("");
        addressCountry.setCountry("");
        addressHouseNumber.setHouseNumber("");
        addressLocalNumber.setLocalNumber("");
        addressPostCode.setPostCode("");
        addressPhone.setPhone("");

        assertFalse(addressChecker.isStreetValid(addresStreet));
        assertFalse(addressChecker.isCityValid(addressCity));
        assertFalse(addressChecker.isCountryValid(addressCountry));
        assertFalse(addressChecker.isHouseNumberValid(addressHouseNumber));
        assertFalse(addressChecker.isLocalNumberValid(addressLocalNumber));
        assertFalse(addressChecker.isPostCodeValid(addressPostCode));
        assertFalse(addressChecker.isPhoneValid(addressPhone));

    }
}
