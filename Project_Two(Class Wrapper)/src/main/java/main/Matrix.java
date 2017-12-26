package main;

import java.util.Random;
import java.util.Scanner;

public class Matrix implements IMatrix {

    Integer rows, columns; //rows and columns of the matrix
    Integer[][] matrix; //matrix 2D

    //initialize the matrix
    public void initMatrix() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows in the matrix : ");
        rows = sc.nextInt();
        System.out.print("Enter the number of columns in the matrix : ");
        columns = sc.nextInt();

        Random random = new Random();
        matrix = new Integer[rows][columns];

        //generate matrix with random numbers in the range[1...10]
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = random.nextInt(10) + 1;
            }
        }
    }

    //output the matrix
    public void printMatrix() {
        //output the Matrix
        System.out.println("\nMatrix is : ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j].intValue() + "\t"); //unboxing Integer to int ((return the value as type int))
            }
            System.out.println();
        }
    }

    //calculate sum of element above
    // and below of the main diagonal of the matrix
    public void sumOfElements() {
        int sum_above_diagonal = 0;
        int sum_below_diagonal = 0;

        // to calculate sum of elements above diagonal.
        for (int j = 1; j < columns; j++) {
            for (int i = j - 1; i >= 0; i--) {
                sum_above_diagonal += matrix[i][j]; //unboxing (return the value as type int)
            }
        }

        System.out.println("\nSum of elements above diagonal is: " + sum_above_diagonal);


        //  to calculate sum of elements below diagonal.
        for (int i = 1; i < rows; i++) {
            for (int j = i - 1; j >= 0; j--) {
                sum_below_diagonal += matrix[i][j]; // unboxing (return the value as type int)
            }
        }

        System.out.println("Sum of elements below diagonal is: " + sum_below_diagonal);
    }

}
