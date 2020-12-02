package persistence;

import domain.Pizza;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbMapper {

    private Database database;

    public DbMapper(Database database) {
        this.database = database;
    }

    public List<Pizza> getAllPizzas(){

        List<Pizza> pizzaList = new ArrayList<>();

        String sql = "select * from pizza";

        try (PreparedStatement ps = database.connect().prepareStatement(sql))  {
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int pizza_no = rs.getInt("pizza_no");
                String name = rs.getString("name");
                String ingredients = rs.getString("ingredients");
                int price = rs.getInt("price");
                pizzaList.add(new Pizza(pizza_no, name, ingredients, price));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return pizzaList;
    }

    public Pizza getPizzaById(int pizzaNo){
        return null;
    }

}
