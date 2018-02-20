package main;

public class Truck extends Vehicle {

    public Truck(Engine engine, GearBox gearBox) {
        super(engine, gearBox);
    }

    @Override
    public void typeEngine() {
        System.out.print("The truck is equipped with an engine type ");
        engine.engineType();
    }

    @Override
    public void typeGearBox() {
        System.out.print("The truck is equipped with an gearbox type ");
        gearBox.typeGearBox();
    }
}
