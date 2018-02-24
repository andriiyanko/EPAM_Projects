package main;

public class Olive extends PizzaDecorator {
    public Olive(Pizza pizza) {
        super(pizza);
    }

    @Override
    double getPrice() {
        return super.getPrice() + 7;
    }

    @Override
    String getIngredients() {
        return super.getIngredients() + ", and with olives";
    }
}
