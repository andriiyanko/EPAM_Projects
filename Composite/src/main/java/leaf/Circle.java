package leaf;

import base.Shape;

public class Circle implements Shape {
    @Override
    public void draw(String color) {
        System.out.println("Drawing circle with color: " + color);
    }
}
