import java.util.Scanner;

public class MealOrder {
    Burger burger;
    Toppings toppings;
    private int toppingsCount;
    private double toppingsPrice;
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
                case "hamburger" ->  new Hamburger("Hamburger");
                case "cheeseburger" -> new Cheeseburger("Cheeseburger");
                case "tastyburger" -> new BigTasty("Tastyburger");
                default -> {
                    System.out.println("Incorrect input, please enter one of the choices: Hamburger/Cheeseburger/Tastyburger.");
                    yield null; //chová se "jako" return
                }
            };
        }
    }

    public void askWantsToppings () {
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
     public void setToppingsCount () {
         System.out.print("Enter the number of toppings you want. The total number should not exceed 3.");
         toppingsCount = -1;
         while (toppingsCount <0) {
             toppingsCount = tryParseInt(s.nextLine(), -1);
             if (toppingsCount <= 0 || toppingsCount > 3) {
                 System.out.println("Please enter a number between 1-3.");
                 toppingsCount = -1;
             }
         }
     }
     public int tryParseInt (String number, int defaultNumber) {
         try {
             return Integer.parseInt(number);
         } catch (NumberFormatException e) {
             return defaultNumber;
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
            System.out.println("Enter type of your drink. (Cola/Fanta/Sprite)");
            String type = s.nextLine();
            System.out.println("Enter its size.");
            String size = s.nextLine();
            drink = switch (size.toLowerCase()) {
                case "small" -> new Drink(type, 0.99,"Small");
                case "medium" -> new Drink(type,1.59, "Medium");
                case "large" -> new Drink(type, 1.89, "Large");
                default -> new Drink();
            };
    }
}
