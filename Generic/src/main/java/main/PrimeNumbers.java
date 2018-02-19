package main;

public class PrimeNumbers implements Condition<Integer> {
    public boolean testCondtion(Integer obj) {
        if (obj == 0 || obj == 1) {
            return false;
        }
        for (int i = 2; i * i <= obj; i++) {
            if (obj % i == 0) {
                return false;
            }
        }
        return true;
    }
}
