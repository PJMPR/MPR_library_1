package library.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import library.domain.User;

public class UserMapper implements IMapper<User> {

	@Override
	public User map(ResultSet rs) throws SQLException {
		User p = new User();
		p.setId(rs.getInt("id"));
		p.setLogin(rs.getString("login"));
		p.setEmail(rs.getString("email"));
		p.setPassword(rs.getString("password"));
		return p;
	}

}
