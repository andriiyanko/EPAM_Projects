package main;

import java.time.*;
import java.util.List;

public class Station {

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private long durationOfRoute;
    private String nameOfDepartureStation;
    private String nameOfArrivalStation;
    private int freeSeats;

    private DayOfWeek[] dayOfWeeks;

    Station(){ }

    public Station(LocalDateTime departureTime, LocalDateTime arrivalTime,
                   String nameOfDepartureStation, String nameOfArrivalStation, int freeSeats) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.nameOfDepartureStation = nameOfDepartureStation;
        this.nameOfArrivalStation = nameOfArrivalStation;
        this.freeSeats = freeSeats;
    }

    public long getDurationTimeOfRoute(){
        durationOfRoute = Duration.between(departureTime,arrivalTime).toHours();
        //System.out.println("Duration of route of the train: " + durationOfRoute);
        return durationOfRoute;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getNameOfDepartureStation() {
        return nameOfDepartureStation;
    }

    public void setNameOfDepartureStation(String nameOfDepartureStation) {
        this.nameOfDepartureStation = nameOfDepartureStation;
    }

    public String getNameOfArrivalStation() {
        return nameOfArrivalStation;
    }

    public void setNameOfArrivalStation(String nameOfArrivalStation) {
        this.nameOfArrivalStation = nameOfArrivalStation;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(int freeSeats) {
        this.freeSeats = freeSeats;
    }
///////////////////////////////////////////////////////////////////

    public DayOfWeek[] getDayOfWeeks() {
        return dayOfWeeks;
    }

    public void setDayOfWeeks(DayOfWeek[] dayOfWeeks) {
        this.dayOfWeeks = dayOfWeeks;
    }
}
