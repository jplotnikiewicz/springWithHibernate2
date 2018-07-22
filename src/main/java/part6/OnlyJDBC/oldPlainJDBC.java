package part6.OnlyJDBC;

import java.sql.*;

public class oldPlainJDBC {

    public static void main(String [] args){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_example?autoReconnect=true&useSSL=false&serverTimezone=Europe/Warsaw","root","root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user");
            while(rs.next()){
                System.out.println(rs.getInt("Id")+ " " + rs.getString("name"));
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
