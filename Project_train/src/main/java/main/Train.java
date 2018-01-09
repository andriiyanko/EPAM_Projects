package main;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Train {

    public static final int week = 7;
    Scanner sc = new Scanner(System.in);
    private int freeSeats;
    private List<Station> stations = new ArrayList();

    private DayOfWeek[] dayOfWeek;


    Train() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.print("Input number of free seats in train: ");
        freeSeats = sc.nextInt();
        while (freeSeats < 0) {
            System.out.println("Please enter number of free seats that is bigger or equal 0. Try again!");
            freeSeats = sc.nextInt();
        }

        String nameOfDepartureStation, nameOfArrivalStation;
        int input = 0;

        while (true) {
            System.out.print("To add departure station - enter 1 , else if you want to finish adding stations - enter 0. User input: ");
            input = sc.nextInt();
            if (input == 0) {
                break;
            }
            System.out.print("Enter name of railway station: ");
            sc.nextLine();
            nameOfDepartureStation = sc.nextLine();

            Station station = new Station();

            System.out.print("Enter date and time of departure (in format: yyyy-MM-dd HH:mm) : ");
            LocalDateTime departureTime = LocalDateTime.parse(sc.nextLine(), formatter); //parse the specified date

            System.out.print("To add arrival station - enter 1 , else if you want to finish adding stations - enter 0. User input: ");
            input = sc.nextInt();
            if (input == 0) {
                break;
            }
            System.out.print("Enter name of railway station: ");
            sc.nextLine();
            nameOfArrivalStation = sc.nextLine();
            System.out.print("Enter date and time of arrival (in format: yyyy-MM-dd HH:mm) : ");
            LocalDateTime arrivalTime = LocalDateTime.parse(sc.nextLine(), formatter);

            ///////////////////////// On what days a train rides along this route ////////////////////////
            System.out.println("Enter days of the week when train goes on the routes (1-Monday, 2-Tuesday, 3-Wednesday etc...). To finish enter 0");
            dayOfWeek = new DayOfWeek[week];
            for (int i = 0; ; i++) {

                input = sc.nextInt();
                if (input == 0) {
                    break;
                }
                if (input < 1 || input > 7) {
                    System.out.println("You enter wrong number. Try again!");
                }
                dayOfWeek[i] = DayOfWeek.of(input);

            }
            ////////////////////////////////////////////////////////////////
            station.setDepartureTime(departureTime);
            station.setNameOfDepartureStation(nameOfDepartureStation);
            station.setArrivalTime(arrivalTime);
            station.setNameOfArrivalStation(nameOfArrivalStation);
            station.setFreeSeats(freeSeats);
            station.setDayOfWeeks(dayOfWeek);
            stations.add(station);
        }

    }

    public List<Station> getStations() {
        return stations;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    public DayOfWeek[] getDayOfWeek() {
        return dayOfWeek;
    }

}
