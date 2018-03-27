package main;

public class CarWashStation implements Runnable{
    private Car car;

    public CarWashStation() {
    }

    public CarWashStation(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        car = new Car();
        System.out.println(car);
    }
}
