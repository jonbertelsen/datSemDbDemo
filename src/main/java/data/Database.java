package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private final String USER;
    private final String PASSWORD;
    private final String URL;
    private Connection connection;


    public Database(String user, String password, String url) {
        this.USER = user;
        this.PASSWORD = password;
        this.URL = url;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Fejl ved instantiering af Driver klasse");
        }
    }

    public Connection connect(){
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Fejl under etablering af forbindelse til database");
        }
        return null;
    }

}
