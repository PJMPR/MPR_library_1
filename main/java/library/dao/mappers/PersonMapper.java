package library.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import library.domain.Person;

public class PersonMapper implements IMapper<Person> {

	@Override
	public Person map(ResultSet rs) throws SQLException {
		Person p = new Person();
		p.setId(rs.getInt("id"));
		p.setName(rs.getString("name"));
		p.setSurname(rs.getString("surname"));
		return p;
	}

}
