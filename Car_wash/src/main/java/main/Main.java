package main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Car dirtyCar = new Car();
        Car foamedCar = dirtyCar;
        Car washedCar = dirtyCar;
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Client(washedCar));
        exec.execute(new FoamCar(dirtyCar, foamedCar));
        exec.execute(new WashCar(foamedCar, washedCar));
        exec.shutdownNow();
    }
}
