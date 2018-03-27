package main;

public class WashCar implements Runnable {
    private Car washCar,foamCar;

    public WashCar() {
    }

    public WashCar(Car washCar, Car foamCar) {
        this.washCar = washCar;
        this.foamCar = foamCar;
    }

    @Override
    public void run() {
        synchronized (foamCar){
            try {
                while (foamCar.getStatus() != Status.FOAMED){
                    foamCar.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            foamCar.washCar();
            System.out.println(foamCar);
            washCar = foamCar;
        }
        new Thread(new Client(washCar)).start();
        System.out.println("Off washing machine");
    }
}
