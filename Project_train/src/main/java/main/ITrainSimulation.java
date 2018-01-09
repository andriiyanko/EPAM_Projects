package main;

import java.util.List;

public interface ITrainSimulation {

    List<Train> printTrainFromToPlaces(String departureStation, String arrivalStation);

    List<Train> findTrainAfterDate(String date);

    List<Train> findTrainByFreePlacesAndLocation(String stationName);

    List<Train> buyTicket(int amount, String departureStation, String arrivalStation);

}
