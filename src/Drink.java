public class Drink {
    private String type;
    private double drinkPrice;
    private String size;

    public Drink(String type, double drinkPrice, String size) {
        this.type = type;
        this.drinkPrice = drinkPrice;
        this.size = size;
    }

    public Drink() {
    }

    public String getType() {
        return type;
    }

    public double getDrinkPrice() {
        return drinkPrice;
    }

    public String getSize() {
        return size;
    }
}




