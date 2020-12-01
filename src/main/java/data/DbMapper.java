package data;

import domain.Pizza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbMapper {

    public List<Pizza> getAllPizzas(){

        List<Pizza> menuCard = new ArrayList<>();

        Database db = new Database("testdb_user", "1234", "jdbc:mysql://localhost:3306/mario?serverTimezone=CET&useSSL=false");

        String sql = "select * from pizza";

        try (Connection connection = db.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int pizza_no = rs.getInt("pizza_no");
                    String name = rs.getString("name");
                    String ingredients = rs.getString("ingredients");
                    int price = rs.getInt("price");
                    menuCard.add(new Pizza(pizza_no, name, ingredients, price));
                }
              }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return menuCard;
    }
}
