package main;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Palace palace = new Palace();
        palace.generatePlaces();
        palace.getLocations();
        palace.findPalace(300, 1000);

    }
}
