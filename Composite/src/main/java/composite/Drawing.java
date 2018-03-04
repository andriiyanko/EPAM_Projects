package composite;

import base.Shape;

import java.util.ArrayList;
import java.util.List;

public class Drawing implements Shape {

    private List<Shape> shapes = new ArrayList<>();

    @Override
    public void draw(String color) {
        for (Shape shape : shapes) {
            shape.draw(color);
        }
    }
    public void add(Shape s){
        this.shapes.add(s);
    }

    public void remove(Shape s){
        this.shapes.remove(s);
    }

    public void clear(){
        System.out.println("All shapes were clearing from drawing.");
        this.shapes.clear();
    }
}
