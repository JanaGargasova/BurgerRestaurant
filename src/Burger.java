public class Burger {
    private String type;
    private double burgerPrice;

    public Burger() {
    }

    public Burger(String type, double burgerPrice) {
        this.type = type;
        this.burgerPrice = burgerPrice;
    }

    public double getBurgerPrice() {
        return burgerPrice;
    }

    public String getType() {
        return type;
    }
}

class Hamburger extends Burger {
    public Hamburger(String type) {
        super(type, 2.99);
    }
}
class Cheeseburger extends Burger {
    public Cheeseburger(String type) {
        super(type, 3.29);
    }
}
class BigTasty extends Burger {
    public BigTasty(String type) {
        super(type, 5.99);
    }
}



