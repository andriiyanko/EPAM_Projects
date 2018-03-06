package main;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Andy", "London", 21, 2, Position.MANAGER));
        employees.add(new Employee("Monter", "Lviv", 44, 17, Position.MANAGER));
        employees.add(new Employee("Smith", "Uganda", 25, 5, Position.WORKER));
        employees.add(new Employee("Emma", "Chicago", 32, 8, Position.MANAGER));
        employees.add(new Employee("Monty", "Manchester", 29, 6, Position.DIRECTOR));
        employees.add(new Employee("Eva", "Los-Angeles", 29, 6, Position.WORKER));
        employees.add(new Employee("Bob", "Manchester", 38, 14, Position.WORKER));
        employees.add(new Employee("Lee", "Miami", 33, 8, Position.DIRECTOR));
        employees.add(new Employee("Morgan", "London", 24, 7, Position.WORKER));

        System.out.println("-----1------");
        printLastN(employees);

        System.out.println("-----2------");
        startWithM(employees);

        System.out.println("-----3------");
        namesMap(employees);

        System.out.println("-----4------");
        findUniqueWorkers(employees);

        System.out.println("-----5------");
        createNewCollection(employees);

        System.out.println("-----6------");
        countEmployees(employees);

        System.out.println("-----7------");
        findAverageExperience(employees);

        System.out.println("-----8------");
        setWorkExperience(employees);

        System.out.println("-----9------");
        findEmployeesNotFromManchester(employees);

        System.out.println("-----10------");
        sortEmployeesByAge(employees);

    }
    //print last n elements
    public static void printLastN(List<Employee> employee){
        employee.stream().skip(employee.size() - 4).forEach(System.out::println);
    }

    public static void startWithM(List<Employee> employees){
        employees.stream().filter(p ->p.getPosition().equals(Position.MANAGER)||p.getPosition().equals(Position.DIRECTOR))
                .filter(p->p.getName().startsWith("M")).forEach(System.out::println);
    }

    public static void namesMap(List<Employee> employees){
        employees.stream().filter(p->p.getPosition().equals(Position.MANAGER)).map(p->p.getName()).forEach(System.out::println);
    }

    public static void findUniqueWorkers(List<Employee>employees){
        employees.stream().filter(p ->p.getPosition().equals(Position.WORKER)).filter(p->p.getWorkExperience()>5).distinct().forEach(System.out::println);
    }

    public static void createNewCollection(List<Employee> employees){
        List<Employee> london = employees.stream().sorted(Comparator.comparing(p->p.getName())).filter(p->p.getNativeCity().equals("London")).collect(Collectors.toList());
        london.forEach(System.out::println);
    }

    public static void countEmployees(List<Employee> employees){
        System.out.println("Count of employees where age is ovet 30: " + employees.stream().filter(p->p.getAge()>30).count());
    }

    public static void findAverageExperience(List<Employee> employees){
        System.out.println("AverageExperience: " + employees.stream().mapToInt(p->p.getWorkExperience()).average().getAsDouble());
    }

    public static void setWorkExperience(List<Employee> employees){
        employees.stream().peek(p->p.setWorkExperience(p.getWorkExperience() + 1)).forEach(System.out::println);
    }

    public static void findEmployeesNotFromManchester(List<Employee> employees){
        employees.stream().filter(p->!p.getNativeCity().equals("Manchester")).filter(p->p.getAge()>25 && p.getAge() < 35).forEach(System.out::println);
    }

    public static void sortEmployeesByAge(List<Employee> employees){
        employees.stream().sorted(Comparator.comparing(Employee::getAge)).forEach(System.out::println);
    }



}


