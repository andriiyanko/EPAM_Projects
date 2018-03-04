package main;

import base.Shape;
import composite.Drawing;
import leaf.Circle;
import leaf.Square;
import leaf.Triangle;

public class Main {
    public static void main(String[] args) {
        Shape triangle = new Triangle();
        Shape circle = new Circle();
        Shape square = new Square();

        Drawing drawing = new Drawing();
        drawing.add(triangle);
        drawing.add(circle);
        drawing.add(square);

        drawing.draw("Black");
        drawing.clear();

        drawing.add(triangle);
        drawing.add(circle);
        drawing.add(square);
        drawing.draw("White");
    }
}
