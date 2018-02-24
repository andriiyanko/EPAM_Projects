package main;

public class PizzaDecorator extends Pizza {
    public Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    double getPrice() {
        return pizza.getPrice();
    }

    @Override
    String getIngredients() {
        return pizza.getIngredients();
    }
}
