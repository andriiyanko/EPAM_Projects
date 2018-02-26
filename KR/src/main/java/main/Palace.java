package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Palace extends Dwelliing {

   private int rent;
   private String palaceName;



    private List<Location> locations = new ArrayList<Location>();
    private List<Palace> palaces ;

    public List<Location> getLocations() {
        return locations;
    }

    public Palace() {
    }

    public Palace(int rent) {
        this.rent = rent;
    }

    public String getPalaceName() {
        return palaceName;
    }

    public void setPalaceName(String palaceName) {
        this.palaceName = palaceName;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getRent() {
        return rent;
    }


    @Override
    public void displayInfo() {
        System.out.println("Total price for palace: " + super.getPrice() + " Rent per month " + getRent());
    }

    public void generatePlaces(){
        Scanner sc = new Scanner(System.in);
        int input = 0;
        String nameOfPalace;
        int rent = 0;
        while (true) {
            System.out.print("To add name for palace - enter 1 , else if you want to finish - enter 0. User input: ");
            input = sc.nextInt();
            if (input == 0) {
                break;
            }
            Palace palace = new Palace();
            System.out.print("Enter palace's name: ");
            sc.nextLine();
            nameOfPalace = sc.nextLine();
            System.out.println("Enter rent:");
            rent = sc.nextInt();


            palace.setPalaceName(palaceName);
            palace.setRent(rent);
            palaces.add(palace);
        }

    }

    public void generateLocations() {
        Scanner sc = new Scanner(System.in);
        int input = 0;
        String nameOfLocation;
        int distance = 0;
        while (true) {
            System.out.print("To add location for palace - enter 1 , else if you want to finish - enter 0. User input: ");
            input = sc.nextInt();
            if (input == 0) {
                break;
            }
            Location location = new Location();
            System.out.print("Enter location: ");
            sc.nextLine();
            nameOfLocation = sc.nextLine();

            System.out.println("Enter distance:");
            distance = sc.nextInt();

            location.setLocation(nameOfLocation);
            location.setDistance(distance);
        }
    }
        public List<Palace> findPalace(int rent, int distance){
            List<Palace> findPalaces = new ArrayList<Palace>();
            for (int i = 0; i < palaces.size(); i++) {
                if (palaces.get(i).getRent() < rent){
                    for (Location location : palaces.get(i).getLocations()){
                        if (location.getDistance() < distance){
                            findPalaces.add(palaces.get(i));
                        }
                    }
            }
        }
        return findPalaces;
    }
}
