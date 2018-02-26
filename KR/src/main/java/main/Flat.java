package main;

public class Flat extends Dwelliing {

   private int rent;

    public Flat() {
    }

    public Flat(int rent) {
        this.rent = rent;
    }



    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    @Override
    public void displayInfo() {
        System.out.println("Total price for flat: " + super.getPrice() + " Rent per month " + getRent());
    }
}
