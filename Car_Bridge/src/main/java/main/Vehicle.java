package main;

public abstract class Vehicle {

    protected Engine engine;
    protected GearBox gearBox;

    public Vehicle(Engine engine, GearBox gearBox) {
        this.engine = engine;
        this.gearBox = gearBox;
    }

    abstract public void typeEngine();
    abstract public void typeGearBox();
}
