package library.dao.repos;

import java.util.List;

import library.domain.Address;

public interface IAddressRepository extends IRepository<Address>{

	public List<Address> withPostCode(String postCode);
	public List<Address> withCity(String city);
	
}
