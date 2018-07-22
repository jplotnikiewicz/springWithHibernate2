package part6.JDBCWithSpring;

import org.springframework.jdbc.core.RowMapper;
import part6.JDBCWithSpring.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId((resultSet.getInt("id")));
        user.setEmail(resultSet.getString("email"));
        user.setName(resultSet.getString("name"));

        return user;
    }
}
