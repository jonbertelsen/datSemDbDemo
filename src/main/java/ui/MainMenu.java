package ui;

import data.DbMapper;
import domain.Pizza;

import java.util.List;

public class MainMenu {

    DbMapper dbMapper = new DbMapper();

    public void mainMenuLoop(){

        boolean running = true;

        while (running){
            showMenu();
            int choice = Input.getInt("Vælg 1-6: ");
            switch (choice){
                case 1: showMenuCard(); break;
                case 6: running = false; break;
            }
        }


    }

    private void showMenuCard() {
        System.out.println("**** Menukort hos Marios");
        List<Pizza> menuCard = dbMapper.getAllPizzas();
        for (Pizza pizza : menuCard) {
            System.out.println(pizza.toString());
        }
    }

    private void showMenu() {
        System.out.println("**** Menu ***** ");
        System.out.println("[1] Show menucard [6] Exit");
    }


}
