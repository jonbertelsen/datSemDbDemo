package domain;

public class Pizza {

    private int pizzaNo;
    private String name;
    private String ingredients;
    private int price;

    public Pizza(int pizzaNo, String name, String ingredients, int price) {
        this.pizzaNo = pizzaNo;
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
    }

    public Pizza() {
    }

    public void setPizzaNo(int pizzaNo) {
        this.pizzaNo = pizzaNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pizza {" +
                "pizzaNo=" + pizzaNo +
                ", name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", price=" + price +
                '}';
    }
}
