package library.domain.checkers;

import library.domain.Address;

public class AddressChecker {
    public boolean isStreetValid(Address address) {
        return address.getStreet()!=null && !address.getStreet().isEmpty();

    }
    public boolean isCityValid(Address address) {
        return address.getCity()!=null && !address.getCity().isEmpty();

    }public boolean isPostCodeValid(Address address) {
        return address.getPostCode()!=null && !address.getPostCode().isEmpty();

    }public boolean isCountryValid(Address address) {
        return address.getCountry()!=null && !address.getCountry().isEmpty();

    }public boolean isHouseNumberValid(Address address) {
        return address.getHouseNumber()!=null && !address.getHouseNumber().isEmpty();

    }public boolean isLocalNumberValid(Address address) {
        return address.getLocalNumber()!=null && !address.getLocalNumber().isEmpty();

    }public boolean isPhoneValid(Address address) {
        return address.getPhone()!=null && !address.getPhone().isEmpty();

    }
}
