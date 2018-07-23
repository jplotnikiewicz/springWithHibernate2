package part6.JDBCWithSpring;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import javax.validation.constraints.Null;
import java.util.List;

public class UserDAOJDBCImpl implements UserDAO {

    private DataSource datasource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDatasource(DataSource ds) {
        datasource = ds;
        jdbcTemplate = new JdbcTemplate(datasource);
    }

    @Override
    public void create(String name, String email) {
        String sql = "insert into user (email, name) values (?, ?)";
        jdbcTemplate.update(sql, email, name);
        System.out.println("Create User name  " + name + "Email = " + email);
    }

    @Override
    public User getUser(Integer id) {
        String sql = "select * from user where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserMapper());
        return user;
    }

    @Override
    public List<User> listUsers() {
        String sql = "select * from user";
        List<User> users = jdbcTemplate.query(sql, new UserMapper());
        return users;
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from user where id = ?";
        jdbcTemplate.update(sql, id);
        System.out.println("Delete Record with ID = " +id);
    }

    @Override
    public void updateEmail(Integer id, String email) {
        String sql = "update user set email = ? where id = ?";
        jdbcTemplate.update(sql, id, email);
        System.out.println("Update Record with ID =" + id);
    }

}
