package main;

public class Location {

    private String location;
    int distance;

    public Location() {
    }

    public Location(String location, int distance) {
        this.location = location;
        this.distance = distance;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
