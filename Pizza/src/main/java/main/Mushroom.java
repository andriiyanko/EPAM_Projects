package main;

public class Mushroom extends PizzaDecorator {
    public Mushroom(Pizza pizza) {
        super(pizza);
    }

    @Override
    double getPrice() {
        return super.getPrice() + 15;
    }

    @Override
    String getIngredients() {
        return super.getIngredients() + ", and with mushrooms";
    }
}
