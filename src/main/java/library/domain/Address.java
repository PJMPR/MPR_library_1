package library.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import library.web.rest.AdressResources;

@Entity
@NamedQueries({
	@NamedQuery(name = "adresses.all", query="SELECT a FROM Adress a"),
	@NamedQuery(name = "adresses.id", query="SELECT a FROM Adress a WHERE a.id=:id")
})
public class Address implements IHaveId{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String street;
	private String city;
	private String postCode;
	private String country;
	private String houseNumber;
	private String localNumber;
	private String phone;
	
	public Address() {
		super();
	}
	

	@ManyToMany(mappedBy="adresses")
	private List<Person> adresses;

	public Address(int id, String street, String city, String postCode, String country, String houseNumber, String localNumber, String phone) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.postCode = postCode;
		this.country = country;
		this.houseNumber = houseNumber;
		this.localNumber = localNumber;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getPostCode() {
		return postCode;
	}
	
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getHouseNumber() {
		return houseNumber;
	}
	
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	
	public String getLocalNumber() {
		return localNumber;
	}
	
	public void setLocalNumber(String localNumber) {
		this.localNumber = localNumber;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}		
	
}
