package main;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.*;

public  abstract class Dwelliing {

    private int price;
    private double square;

    public void setPrice(int price) {
         this.price = price;
     }

     public void setSquare(double square) {
         this.square = square;
     }

     public int getPrice() {
         return price;
     }

     public double getSquare() {
         return square;
     }

     public abstract void displayInfo();

 }
