package ui;

import domain.Pizza;
import persistence.Database;
import persistence.DbMapper;

import java.util.List;

public class MainMenu {

    private final String USER = "testdb_user";
    private final String PASSWORD = "1234";
    private final String URL = "jdbc:mysql://localhost:3306/mario?serverTimezone=CET&useSSL=false";

    private Database database = new Database(USER, PASSWORD, URL);
    private DbMapper dbMapper = new DbMapper(database);

    public void mainMenuLoop() {

        boolean running = true;

        while (running) {
            showMenu();
            switch(Input.getInt("Vælg 1-6: ")){
                case 1: showMenuCard(); break;
                case 6: running = false; break;
            }
        }
        System.out.println("Tak for denne gang!");
    }

    private void showMenuCard() {
        System.out.println("**** Menukort hos Marios ******");
        // Todo: skal hente alle pizzaer fra database tabellen pizza i en arrayliste og skrive dem ud
        List<Pizza> menuCard = dbMapper.getAllPizzas();
        for (Pizza pizza : menuCard) {
            System.out.println(pizza.toString());
        }
    }

    private void showMenu() {
        System.out.println("**** Marios pizzabar - hovedmenu ******");
        System.out.println("[1] Vis menukort [6] Afslut");
    }
}
