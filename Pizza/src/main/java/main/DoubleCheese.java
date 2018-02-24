package main;

public class DoubleCheese extends PizzaDecorator {
    public DoubleCheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    double getPrice() {
        return super.getPrice() + 20;
    }

    @Override
    String getIngredients() {
        return super.getIngredients() + ", and with double cheese";
    }
}
