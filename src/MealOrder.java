import java.util.Scanner;

public class MealOrder {
    Burger burger;
    Toppings toppings;
    private int toppingsCount;
    private boolean hasTopping = false;
    private double toppingsPrice;
    private String allToppings;
    Drink drink;

    public MealOrder() {
    }
    public MealOrder(Burger burger) {
        this.burger = burger;
    }
    public MealOrder(Toppings toppings) {
        this.toppings = toppings;
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

    public Drink getDrink() {
        return drink;
    }

    Scanner s = new Scanner(System.in);

    public void createBurger() {
        System.out.println("Choose your burger (Hamburger for 1$/Cheeseburger for 2$/Tastyburger for 3$).");
        String burgerName = s.nextLine();
        burger = switch (burgerName.toLowerCase()) {
            case "hamburger" -> new Hamburger("Hamburger");
            case "cheeseburger" -> new Cheeseburger("Cheeseburger");
            case "tastyburger" -> new BigTasty("Tastyburger");
            default -> new Hamburger("Hamburger");
        };
    }
    public void setToppingsCount() {

        while (true) {
            System.out.print("Would you like to add any toppings? (Yes / No): ");
            String yesOrNot = s.nextLine().toUpperCase();

            switch (yesOrNot) {
                case "YES" -> {
                    while (true) {
                            System.out.print("Enter the number of toppings you want. The total number should not " +
                                    "exceed 3: ");
                            toppingsCount = s.nextInt();
                        if (toppingsCount > 3) {
                            System.out.println("You entered a number greater than 3. Please try again");
                            continue;
                        }
                        if (toppingsCount <= 0) {
                            System.out.println("You entered a number less than or equal to 0. Please try again.");
                            continue;
                        }
                        hasTopping = true;
                        break;
                    }
                }
                case "NO" -> toppingsCount = 0;
                default -> {
                    System.out.println("Incorrect entry, please try again.");
                    continue;
                }
            }
            break;
        }
    }
    public void setToppingPrice(int toppingsCount) {

        toppingsPrice = 0;
        allToppings = "";

        while (toppingsCount != 0) {
            System.out.println("Enter your desired topping: ");
            Toppings topping = Toppings.getTopping(s.nextLine());
            allToppings += (allToppings.isEmpty()) ? topping.getTopping() : "|" + topping.getTopping();
            toppingsPrice += topping.getToppingPrice();
            toppingsCount--;
        }
    }
    public void orderDrink () {
        while (true) {
            System.out.println("Enter type of your drink. (Cola/Fanta/Sprite)");
            String type = s.nextLine();
            if ("Qq".contains(type)) {
                break;
            }
            System.out.println("Enter its size.");
            String size = s.nextLine();
            drink = switch (size.toLowerCase()) {
                case "small" -> new Drink(type, 0.99,"Small");
                case "medium" -> new Drink(type,1.59, "Medium");
                case "large" -> new Drink(type, 1.89, "Large");
                default -> new Drink();
            };
            break;
        }
    }
}
