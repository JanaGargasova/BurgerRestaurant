public class Main {
    public static void main(String[] args) {

            Menu menu = new Menu();
            menu.getMenu();
            MealOrder mealOrder = new MealOrder();
            mealOrder.createBurger();
            mealOrder.askWantsToppings();
            mealOrder.setToppingPrice(mealOrder.getToppingsCount());
            mealOrder.orderDrinkType();
            System.out.println(mealOrder.drink.getDrinkPrice());
            System.out.println("Your total price is: " + Double.sum(mealOrder.getToppingsPrice(), mealOrder.getBurger().getBurgerPrice()));
            System.out.println("Your order is: A " + mealOrder.getBurger().getType() + " with extra " + mealOrder.getAllToppings() +
                               " and " + mealOrder.drink.getSize() + " " + mealOrder.drink.getType() + ".");
        }

    }

