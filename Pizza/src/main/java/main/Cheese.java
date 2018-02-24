package main;

public class Cheese extends PizzaDecorator {
    public Cheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    double getPrice() {
        return super.getPrice() + 10;
    }

    @Override
    String getIngredients() {
        return super.getIngredients() + ", and with cheese";
    }
}
