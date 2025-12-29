import java.util.Scanner;

public class Menu {
    private String menu;

    public Menu() {
    }

    public void getMenu() {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Hi dear and welcome in our Burger restaurant. Would you like to order?");
            String yesOrNo = scanner.nextLine().toUpperCase();
            while (true) {
                switch (yesOrNo) {
                    case "YES" -> {
                        System.out.println("""
                                
                                            \nBurger Restaurant menu:
                                            Burgers:
                                                1. Hamburger ------------------------- 2.99$
                                                2. Cheeseburger ---------------------- 3.29$
                                                3. Big Tasty Single ------------------ 5.99$
                                              Add-ons:
                                                  \\u2022 Onion  -------------------------- 0.30$
                                                  \\u2022 Radish -------------------------- 0.30$
                                                  \\u2022 Bacon  -------------------------- 0.99$
                                                  \\u2022 Cheese -------------------------- 0.55$
                                            Drinks:
                                                1. Coca-Cola (S/M/L) -------- 0.99/1.59/1.89$
                                                2. Fanta (S/M/L) ------------ 1.00/1.25/1.50$
                                                3. Sprite (S/M/L) ----------- 1.00/1.25/1.50$
                                """);
                        break;
                    }
                    case "NO" -> {
                        System.out.println("Never mind, see you next time!");
                        System.exit(0);
                    }
                    default -> {
                        System.out.println("Incorrect entry, please try again.");
                    }
                }
                if (yesOrNo.equals("YES") || yesOrNo.equals("NO")) {
                    break;
                }
            }

    }
}
