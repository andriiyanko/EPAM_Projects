package main;

public class OddNumber implements Condition<Integer> {

    public boolean testCondtion(Integer odd) {

        return odd % 2 != 0;
    }
}
