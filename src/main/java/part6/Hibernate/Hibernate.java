package part6.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Hibernate {

    public static void main(String [] args){

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        session.beginTransaction();

        try{
            deleteUser(session);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            factory.close();
        }

    }

    private static void getAllUsers(Session session){
        List<User> userList = (List<User>) session.createQuery("from User").list();
        for (User user : userList) {
            System.out.println(user.getId() + " " + user.getName() + " " + user.getEmail());
        }
    }

    private static void createNewUser (Session session){
        User user = new User( 203,"Alex", "hib1@hib.pl");
        session.save(user);
    }

    private static void getUsersWithAlexName(Session session){
        List<User> userList = (List<User>)session.createQuery("from User AS u where u.name = 'Alex'").list();
        for (User user : userList) {
            System.out.println(user.getId() + " " + user.getName() + " " + user.getEmail());
        }

    }

    private static void editSingleUserName(Session session){
        User user = session.get(User.class, 200);
        user.setName("Kay");

    }

    private static void deleteUser(Session session){
        User user = session.get(User.class, 200);
        session.delete(user);
        session.getTransaction().commit();

    }


}
