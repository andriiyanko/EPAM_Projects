package main;

public class Client implements Runnable {
    private Car washCar;

    public Client(Car washCar) {
        this.washCar = washCar;
    }

    @Override
    public void run() {
        synchronized (washCar){
            while (washCar.getStatus() != Status.WASHED){
                try {
                    washCar.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thanks" + washCar);
            System.out.println("You can go from here.");
        }
    }
}
