public class Toppings {
    private String topping;
    private double toppingPrice;

    public Toppings() {
    }

    public Toppings(String topping, double toppingPrice) {
        this.topping = topping;
        this.toppingPrice = toppingPrice;
    }

    public static Toppings getTopping(String topping) {
        return switch (topping.toLowerCase()) {
            case "bacon" -> new BaconTopping("Bacon");
            case "cheese" -> new CheeseTopping("Cheese");
            case "onion" -> new OnionTopping("Onion");
            case "radish" -> new RadishTopping("Radish");
            default -> new Toppings();
        };
    }

    public double getToppingPrice() {
        return toppingPrice;
    }

    public String getTopping() {
        return topping;
    }
}
class BaconTopping extends Toppings {
    public BaconTopping (String topping) {
        super(topping, 0.99);
    }
}
class CheeseTopping extends Toppings {
    public CheeseTopping (String topping) {
        super(topping, 0.55);
    }
}
class OnionTopping extends Toppings {
    public OnionTopping(String topping) {
        super(topping, 0.30);
    }
}class RadishTopping extends Toppings {
    public RadishTopping(String topping) {
        super(topping, 0.30);
    }
}