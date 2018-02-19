package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {


    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        ArrayList<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add("OKO");
        stringArrayList.add("AKA");
        stringArrayList.add("Vardy");

        int count = Main.countElements(arrayList, new OddNumber());
        int countPalindrome = Main.countElements(stringArrayList, new Palindrome());
        int countPrimeNumbers = Main.countElements(arrayList, new PrimeNumbers());

        System.out.println("Count odd elements in array :" + count);
        System.out.println("Count palindromes in array :" + countPalindrome);
        System.out.println("Count prime numbers in array:" + countPrimeNumbers);

    }

    static <T> int countElements(Collection<T> collection, Condition<T> condition) {
        int count = 0;

        for (T elem : collection)
            if (condition.testCondtion(elem))
                ++count;
        return count;
    }

}
