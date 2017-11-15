package library.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import library.domain.Address;

public class AddressMapper implements IMapper<Address> {

	@Override
	public Address map(ResultSet rs) throws SQLException {
		Address address= new Address();
		address.setId(rs.getInt("id"));
		address.setStreet(rs.getString("street"));
		address.setCity(rs.getString("city"));
		address.setPostCode(rs.getString("postCode"));
		address.setCountry(rs.getString("country"));
		address.setHouseNumber(rs.getString("houseNumber"));
		address.setLocalNumber(rs.getString("localNumber"));
		address.setPhone(rs.getString("phone"));
		
		return address;
	}

}
