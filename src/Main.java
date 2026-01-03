public class Main {
    public static void main(String[] args) {

            Menu menu = new Menu();
            menu.getMenu();
            MealOrder mealOrder = new MealOrder();
            mealOrder.createBurger();
//            System.out.println(mealOrder.getBurger().getBurgerPrice());
            mealOrder.askWantsToppings();
            mealOrder.setToppingPrice(mealOrder.getToppingsCount());
            mealOrder.orderDrinkType();
            System.out.println(mealOrder.drink.getDrinkPrice());
            System.out.println("Your total price is: " + mealOrder.getToppingsPrice() + mealOrder.getBurger().getBurgerPrice()); //:D
            System.out.println("Your order is: A " + mealOrder.getBurger() + " with extra " + mealOrder.getAllToppings());
        }
    }

