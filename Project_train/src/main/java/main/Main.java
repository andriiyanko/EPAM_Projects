package main;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Train> trainList; //list of trains
        TrainSimulation trainSimulation = new TrainSimulation();
        trainSimulation.generateTrains(); //generate array of trains

        ///////////////// get trains that go by specified route//////////////////////////
        trainList = trainSimulation.printTrainFromToPlaces("Lviv", "Odessa");
        System.out.println();
        for (int i = 0; i < trainList.size(); i++) {
            for (Station station : trainList.get(i).getStations()) {
                System.out.println("Train number: " + (i + 1));
                System.out.println("The days on which the train is moving along a given route : "
                        + Arrays.toString(trainList.get(i).getDayOfWeek()));
               // System.out.println("DAYS : " + Arrays.toString(station.getDayOfWeeks()));
                System.out.println(trainList.get(i).getFreeSeats() + " " + "free seats");
                System.out.printf("Departure station: %s  Arrival station: %s  Total time of the route: %s hours \n",
                        station.getNameOfDepartureStation(), station.getNameOfArrivalStation(), station.getDurationTimeOfRoute());
            }
        }

        /////////////////get trains that go after specified date ////////////////
        trainList = trainSimulation.findTrainAfterDate("2018-01-01 12:12");
        System.out.println();
        for (int i = 0; i < trainList.size(); i++) {
            for (Station station : trainList.get(i).getStations()) {
                System.out.println("Train number: " + (i + 1));
                System.out.println(trainList.get(i).getFreeSeats() + " " + "free seats");
                System.out.printf("Departure station: %s  Arrival station: %s  Total time of the route: %s hours \n",
                        station.getNameOfDepartureStation(), station.getNameOfArrivalStation(), station.getDurationTimeOfRoute());
            }
        }

        //////////////get trains by free seats and location////////////////////
        trainList = trainSimulation.findTrainByFreePlacesAndLocation("L");
        System.out.println();
        for (int i = 0; i < trainList.size(); i++) {
            for (Station station : trainList.get(i).getStations()) {
                System.out.println("Train number: " + (i + 1));
                System.out.println(trainList.get(i).getFreeSeats() + " " + "free seats");
                System.out.printf("Departure station:%s  Arrival station:%s  Total time of the route:%s hours \n",
                        station.getNameOfDepartureStation(), station.getNameOfArrivalStation(), station.getDurationTimeOfRoute());
            }
        }

        System.out.println();
        trainSimulation.buyTicket(2, "Lviv", "Odessa");

    }


}


