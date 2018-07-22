package part6.JDBCWithSpring;

import part6.JDBCWithSpring.User;

import javax.sql.DataSource;
import java.util.List;

public interface UserDAO {

    public void setDatasource(DataSource ds);
    public void create(String name, String email);
    public User getUser(Integer id);
    public List<User> listUsers();
    public void updateEmail(Integer id, String email);
    public void delete(Integer id);
}
