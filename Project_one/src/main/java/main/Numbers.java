package main;

import java.util.Scanner;

public class Numbers {

    //sort array in ascending order
    public void bubbleSort() {

        System.out.println("\nBubbleSort().......");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = in.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Input number: ");
            arr[i] = in.nextInt();

        }

        //sort array in ascending order
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                // System.out.print(arr[i] + ",");
            }

        }
        System.out.print("Ascending order: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    //find prime numbers in array
    public void primeNumber() {
        System.out.println("\n\nPrimeNumber()......");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of elements in array: ");
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Input number: ");
            arr[i] = in.nextInt();

        }
        // loop through the numbers one by one
        for (int i = 0; i < arr.length; i++) {
            boolean isPrime = true;
            if (arr[i] == 1) {
                isPrime = false;
            } else {
                // check to see if the numbers are prime
                for (int j = 2; j < arr[i]; j++) {
                    if (arr[i] % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            if (isPrime)
                System.out.print(arr[i] + " ");
        }
    }

    //find the elements of the array that are divided into the previous one without a residual
    public void divisionByModule() {
        System.out.println("\n\nDivisionByModule() ......");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter numbers of elements in array: ");
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Input number: ");
            arr[i] = in.nextInt();
        }

        //check if the current % previous == 0
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] % arr[i - 1] == 0)
                System.out.println("Array: " + arr[i] + " ");
        }
    }


}
