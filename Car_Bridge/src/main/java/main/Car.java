package main;

public class Car extends Vehicle {

    public Car(Engine engine, GearBox gearBox) {
        super(engine, gearBox);
    }

    @Override
    public void typeEngine() {
        System.out.print("The car is equipped with an engine type ");
        engine.engineType();
    }

    @Override
    public void typeGearBox() {
        System.out.print("The car is equipped with an gearbox type ");
        gearBox.typeGearBox();
    }
}
