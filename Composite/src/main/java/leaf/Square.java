package leaf;

import base.Shape;

public class Square implements Shape {
    @Override
    public void draw(String color) {
        System.out.println("Drawing square with color: " + color);
    }
}
