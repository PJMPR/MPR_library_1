package library.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import library.domain.Author;

public class AuthorMapper implements IMapper<Author> {

	@Override
	public Author map(ResultSet rs) throws SQLException {
		Author p = new Author();
		p.setId(rs.getInt("id"));
		p.setFirstName(rs.getString("firstName"));
		p.setLastName(rs.getString("lastName"));
		return p;
	}



}
