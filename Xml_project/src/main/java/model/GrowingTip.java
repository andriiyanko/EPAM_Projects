package model;

public class GrowingTip {
    private double temperature;
    private boolean lighting;
    private double watering;

    public GrowingTip() {
    }

    public GrowingTip(double temperature, boolean lighting, double watering) {
        this.temperature = temperature;
        this.lighting = lighting;
        this.watering = watering;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public boolean isLighting() {
        return lighting;
    }

    public void setLighting(boolean lighting) {
        this.lighting = lighting;
    }

    public double getWatering() {
        return watering;
    }

    public void setWatering(double watering) {
        this.watering = watering;
    }

    @Override
    public String toString() {
        return "GrowingTip{" +
                "temperature=" + temperature +
                ", lighting=" + lighting +
                ", watering=" + watering +
                '}';
    }
}
