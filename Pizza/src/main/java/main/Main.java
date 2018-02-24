package main;

public class Main {

    public static void main(String[] args) {
        Pizza pizza = new Olive(new Ham(new DoubleCheese(new Mushroom(new OriginalPizza()))));
        if (pizza.getPrice() > 100){
            System.out.println("You buy King size pizza");
        }
        System.out.println("Pizza price " + pizza.getPrice());
        System.out.println(pizza.getIngredients());
    }
}
