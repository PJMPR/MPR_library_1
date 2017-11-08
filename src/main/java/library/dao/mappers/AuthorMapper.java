package library.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import library.domain.Author;

public class AuthorMapper implements IMapper<Author> {

	@Override
	public Author map(ResultSet rs) throws SQLException {
		Author p = new Author();
		p.setId(rs.getInt("id"));
		p.setFirst_name(rs.getString("first_name"));
		p.setLast_name(rs.getString("last_name"));
		return p;
	}



}
