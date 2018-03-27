package main;

public class FoamCar implements Runnable {
    private Car dirtyCar;
    private Car foamedCar;

    public FoamCar() {
    }

    public FoamCar(Car dirtyCar, Car foamedCar) {
        this.dirtyCar = dirtyCar;
        this.foamedCar = foamedCar;
    }

    @Override
    public void run() {
        synchronized (dirtyCar){
            while (dirtyCar.getStatus()!= Status.DIRTY) {
                try {
                    dirtyCar.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dirtyCar.foamCar();
                System.out.println(dirtyCar);
                foamedCar = dirtyCar;
                new Thread(new WashCar(dirtyCar, foamedCar)).start();
            }
        }
        System.out.println("Off foaming car");
    }
}
