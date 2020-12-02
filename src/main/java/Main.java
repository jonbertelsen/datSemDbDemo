import ui.MainMenu;
import java.sql.*;

public class Main {

    private static final String USER = "testdb_user";
    private static final String PASSWORD = "1234";
    private static final String URL = "jdbc:mysql://localhost:3306/mario?serverTimezone=CET&useSSL=false";
    private static Connection connection;


    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.mainMenuLoop();
    }

}
