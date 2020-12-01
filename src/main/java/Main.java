import data.Database;
import ui.MainMenu;

import java.sql.*;

public class Main {

    private static Connection connection;

    public static void main(String[] args) {
        System.out.println("***** JDBC demo ******");

        MainMenu mainMenu = new MainMenu();
        mainMenu.mainMenuLoop();

    }
}
