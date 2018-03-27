package main;

import java.util.Objects;

public class Car {
    private Status status = Status.DIRTY;

    public Car() {

    }

    public Car(Status status) {
        this.status = status;
    }

    public void foamCar(){
         status = Status.FOAMED;
    }

    public void washCar(){
        status = Status.WASHED;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Car{" +
                "status=" + status +
                '}';
    }

}
