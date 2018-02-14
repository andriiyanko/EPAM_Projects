package model;

public class Flower {
    private int flowerNo;
    private String name;
    private String soil;
    private String origin;
    private VisualParameter visual_parameter;
    private GrowingTip growing_tip;
    private String multiplying;

    public Flower() {
    }

    public Flower(int flowerNo, String name, String soil, String origin, VisualParameter visual_parameter, GrowingTip growing_tip, String multiplying) {
        this.flowerNo = flowerNo;
        this.name = name;
        this.soil = soil;
        this.origin = origin;
        this.visual_parameter = visual_parameter;
        this.growing_tip = growing_tip;
        this.multiplying = multiplying;
    }

    public int getFlowerNo() {
        return flowerNo;
    }

    public void setFlowerNo(int flowerNo) {
        this.flowerNo = flowerNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSoil() {
        return soil;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public VisualParameter getVisual_parameter() {
        return visual_parameter;
    }

    public void setVisual_parameter(VisualParameter visual_parameter) {
        this.visual_parameter = visual_parameter;
    }

    public GrowingTip getGrowing_tip() {
        return growing_tip;
    }

    public void setGrowing_tip(GrowingTip growing_tip) {
        this.growing_tip = growing_tip;
    }

    public String getMultiplying() {
        return multiplying;
    }

    public void setMultiplying(String multiplying) {
        this.multiplying = multiplying;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "flowerNo=" + flowerNo +
                ", name='" + name + '\'' +
                ", soil='" + soil + '\'' +
                ", origin='" + origin + '\'' +
                ", visual_parameter=" + visual_parameter +
                ", growing_tip=" + growing_tip +
                ", multiplying='" + multiplying + '\'' +
                '}';
    }
}
