import java.sql.*;

public class Main {

    private static final String USER = "testdb_user";
    private static final String PASSWORD = "1234";
    private static final String URL = "jdbc:mysql://localhost:3306/mario?serverTimezone=CET&useSSL=false";
    private static Connection connection;


    public static void main(String[] args) {
        System.out.println("***** JDBC demo ******");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Fejl ved instantiering af Driver klasse");
        }

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Fejl under etablering af forbindelse til database");
        }

        String sql = "select * from pizza";

        try (PreparedStatement ps = connection.prepareStatement(sql))  {
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int pizza_no = rs.getInt("pizza_no");
                String name = rs.getString("name");
                String ingredients = rs.getString("ingredients");
                int price = rs.getInt("price");

                System.out.println("Pizza Nr:" + pizza_no);
                System.out.println("Pizza navn: " + name);
                System.out.println("Indhold: " + ingredients);
                System.out.println("Pris: " + price);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
