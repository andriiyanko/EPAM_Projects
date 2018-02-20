package main;

public class CarPattern {
    public static void main(String[] args) {
        Vehicle car = new Car(new DieselEngine(),new ManualGearBox());
        car.typeEngine();
        car.typeGearBox();
        System.out.println();

        Vehicle truck = new Truck(new PatrolEngine(), new AutoGearBox());
        truck.typeEngine();
        truck.typeGearBox();
        System.out.println();

        Vehicle bus = new Bus(new ElectricEngine(), new ManualGearBox());
        bus.typeEngine();
        bus.typeGearBox();
    }
}
