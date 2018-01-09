package main;

import javafx.scene.shape.TriangleMesh;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TrainSimulation implements ITrainSimulation {

    Scanner sc = new Scanner(System.in);
    private List<Train> routes;

    ////////////////Generete Array Of Trains///////////////////////////
    public void generateTrains() {
        routes = new ArrayList();
        System.out.println("To add new train - enter 1, to finish adding - enter 0");
        int input = sc.nextInt();
        while (input == 1) {
            routes.add(new Train());
            System.out.println("To add new train - enter 1, to finish adding - enter 0");
            input = sc.nextInt();
            if (input == 0) {
                break;
            }
        }
    }

    ////////////// Find Trains That Goes On The Specified Route////////////
    public List<Train> printTrainFromToPlaces(String departureStation, String arrivalStation) {
        List<Train> trainList = new ArrayList();
        for (int i = 0; i < routes.size(); i++) {
            for (Station station : routes.get(i).getStations()) {
                if (station.getNameOfDepartureStation().equalsIgnoreCase(departureStation) &&
                        station.getNameOfArrivalStation().equalsIgnoreCase(arrivalStation)) {
                    trainList.add(routes.get(i));
                }

            }
        }
        return trainList;
    }

    //////////// Find Trains That Goes After The Specified Date
    public List<Train> findTrainAfterDate(String date) {
        List<Train> trainList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime currentDataTime = LocalDateTime.parse(date, formatter);
        for (int i = 0; i < routes.size(); i++) {
            for (Station station : routes.get(i).getStations()) {
                if (station.getDepartureTime().isAfter(currentDataTime)) {
                    trainList.add(routes.get(i));
                }
            }
        }
        return trainList;
    }

    ////////////////// Find Trains By Free Places and Location(departure or arrival station)/////////////
    public List<Train> findTrainByFreePlacesAndLocation(String stationName) {
        List<Train> trainList = new ArrayList();
        String substr = stationName.substring(0, 1);
        for (int i = 0; i < routes.size(); i++) {
            if (routes.get(i).getFreeSeats() > 0) {
                for (Station station : routes.get(i).getStations()) {
                    if (station.getNameOfDepartureStation().startsWith(substr) ||
                            station.getNameOfArrivalStation().startsWith(substr)) {
                        trainList.add(routes.get(i));
                    }
                }
            }
        }
        return trainList;
    }

    ////////////////////Buy ticket on train ////////////
    public List<Train> buyTicket(int amount, String departureStation, String arrivalStation) {
        List<Train> trainList = new ArrayList();
        int remainder = 0;
        for (int i = 0; i < routes.size(); i++) {
            if (routes.get(i).getFreeSeats() > amount) {
                for (Station station : routes.get(i).getStations()) {
                    if (station.getNameOfDepartureStation().equalsIgnoreCase(departureStation) &&
                            station.getNameOfArrivalStation().equalsIgnoreCase(arrivalStation)) {
                        remainder = station.getFreeSeats() - amount;
                        station.setFreeSeats(remainder);
                        //  station.setFreeSeats(station.getFreeSeats() - amount);
                        trainList.add(routes.get(i));
                        System.out.printf(" Train number:%d. Free places after purchase the tickets:%d Departure station:%s " +
                                        "Arrival station:%s \n",i+1, station.getFreeSeats(),
                                station.getNameOfDepartureStation(), station.getNameOfArrivalStation());
                    }
                }
            }

        }
        return trainList;
    }

}
