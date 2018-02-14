package model;

public class VisualParameter {
    private String color_stem;
    private String color_leaf;
    private double flower_average_size;

    public VisualParameter() {
    }

    public VisualParameter(String color_stem, String color_leaf, double flower_average_size) {
        this.color_stem = color_stem;
        this.color_leaf = color_leaf;
        this.flower_average_size = flower_average_size;
    }

    public String getColor_stem() {
        return color_stem;
    }

    public void setColor_stem(String color_stem) {
        this.color_stem = color_stem;
    }

    public String getColor_leaf() {
        return color_leaf;
    }

    public void setColor_leaf(String color_leaf) {
        this.color_leaf = color_leaf;
    }

    public double getFlower_average_size() {
        return flower_average_size;
    }

    public void setFlower_average_size(double flower_average_size) {
        this.flower_average_size = flower_average_size;
    }

    @Override
    public String toString() {
        return "VisualParameter{" +
                "color_stem='" + color_stem + '\'' +
                ", color_leaf='" + color_leaf + '\'' +
                ", flower_average_size=" + flower_average_size +
                '}';
    }
}
