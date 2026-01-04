import java.util.Scanner;

public class MealOrder {
    Burger burger;
    Toppings toppings;
    private int toppingsCount;
    private double toppingsPrice = 0;
    private String allToppings;
    Drink drink;

    public MealOrder() {
    }

    public Burger getBurger() {
        return burger;
    }

    public int getToppingsCount() {
        return toppingsCount;
    }

    public double getToppingsPrice() {
        return toppingsPrice;
    }

    public String getAllToppings() {
        return allToppings;
    }

    Scanner s = new Scanner(System.in);


    public void createBurger() {
        System.out.println("First, choose your burger: Hamburger/Cheeseburger/Tastyburger.");
        String burgerName;
        while (burger == null) {
            burgerName = s.nextLine();
            burger = switch (burgerName.toLowerCase()) {
                case "hamburger" -> new Hamburger("Hamburger");
                case "cheeseburger" -> new Cheeseburger("Cheeseburger");
                case "tastyburger" -> new BigTasty("Tastyburger");
                default -> {
                    System.out.println("Incorrect input, please enter one of the choices: Hamburger/Cheeseburger/Tastyburger.");
                    yield null; //chová se "jako" return
                }
            };
        }
    }

    public void askWantsToppings() {
        System.out.print("Would you like to add any toppings? (Yes / No): ");
        String wantsToppings = null;
        while (wantsToppings == null) {
            wantsToppings = s.nextLine().toUpperCase();
            switch (wantsToppings) {
                case "YES" -> setToppingsCount();
                case "NO" -> System.out.println("Without toppings");
                default -> {
                    System.out.println("Please enter either Yes or No.");
                    wantsToppings = null;
                }
            }
        }
    }

    public void setToppingsCount() {
        System.out.print("Enter the number of toppings you want. The total number should not exceed 3.");
        toppingsCount = -1;
        while (toppingsCount < 0) {
            toppingsCount = tryParseInt(s.nextLine(), -1);
            if (toppingsCount <= 0 || toppingsCount > 3) {
                System.out.println("Please enter a number between 1-3.");
                toppingsCount = -1;
            }
        }
    }

    public int tryParseInt(String number, int defaultNumber) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return defaultNumber;
        }
    }

    public void setToppingPrice(int toppingsCount) {

//        toppingsPrice = 0;
        allToppings = "";

        while (toppingsCount != 0) {
            System.out.println("Enter your desired topping: ");
            Toppings topping = Toppings.getTopping(s.nextLine());
            while (topping == null) {
                System.out.println("Incorrect input, please choose one of the toppings: bacon/cheese/onion/radish.");
                topping = Toppings.getTopping(s.nextLine());
            }
            allToppings += (allToppings.isEmpty()) ? topping.getTopping() : "|" + topping.getTopping();
            toppingsPrice += topping.getToppingPrice();
            toppingsCount--;
        }
    }

    public void orderDrinkType() {
        String drinkType = null;
        while (drinkType == null) {
            System.out.println("Enter type of your drink. (Cola/Fanta/Sprite)");
            drinkType = s.nextLine();
            switch (drinkType.toLowerCase()) {
                case "cola", "fanta", "sprite" -> drinkSize(drinkType);
                default -> {
                    System.out.println("Incorrect input.");
                    drinkType = null;
                }
            }
        }
    }

    public void drinkSize(String drinkType) {
        System.out.println("Please enter its size.");
        String size;
        while (drink == null) {
            size = s.nextLine();
            drink = switch (size.toLowerCase()) {
                case "small" -> new Drink(drinkType, 0.99, "small");
                case "medium" -> new Drink(drinkType, 1.59, "medium");
                case "large" -> new Drink(drinkType, 1.89, "large");
                default -> {
                    System.out.println("Incorrect input, please enter drink size small/large/medium.");
                    yield null;
                }
            };
        }
    }
}
