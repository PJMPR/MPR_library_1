package library.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import library.domain.Book;


public class BookMapper implements IMapper<Book> {
	@Override
	public Book map(ResultSet rs) throws SQLException {
		Book p = new Book();
		p.setId(rs.getInt("id"));
		p.setTitle(rs.getString("title"));
		p.setPublisher(rs.getString("publisher"));
		p.setYear(rs.getInt("year"));
		return p;
	}

}
