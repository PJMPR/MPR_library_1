package library.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;


@Entity
@NamedQueries({
	@NamedQuery(name = "persons.all", query="SELECT p FROM Person p"),
	@NamedQuery(name = "persons.id", query="SELECT p FROM Person p WHERE p.id=:id")
})
public class Person implements IHaveId{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String surname;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surrname) {
		this.surname = surrname;
	}
	

}
