package main;

public class Bus extends Vehicle {

    public Bus(Engine engine, GearBox gearBox) {
        super(engine, gearBox);
    }

    @Override
    public void typeEngine() {
        System.out.print("The bus is equipped with an engine type ");
        engine.engineType();
    }

    @Override
    public void typeGearBox() {
        System.out.print("The bus is equipped with an gearbox type ");
        gearBox.typeGearBox();

    }
}
