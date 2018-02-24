package main;

public class Ham extends PizzaDecorator {
    public Ham(Pizza pizza) {
        super(pizza);
    }

    @Override
    double getPrice() {
        return super.getPrice() + 12;
    }

    @Override
    String getIngredients() {
        return super.getIngredients() + ", and with ham";
    }
}
