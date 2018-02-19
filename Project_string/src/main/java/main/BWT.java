package main;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BWT {

    /* move first letter of previous string to end. */
    public static void genRotations(String source, String[] s) {
        s[0] = source;
        for (int i = 1; i < source.length(); i++) {
            s[i] = s[i - 1].substring(1) + s[i - 1].charAt(0);
        }
    }

    /* print the string array to see transformation*/
    public static void printArray(String[] s, int size) {
        for (int i = 0; i < size; i++) {
            System.out.println(s[i]);
        }
        System.out.println();
    }

    /* find the row that matches to original input so we can decode*/
    public static void findKey(String s, String[] strings) {
        int key;
        for (int i = 0; i < s.length(); i++) {
            String match = strings[i];
            while (match == s) {
                key = i;
                System.out.println("YOUR INDEX KEY IS:----->" + key + "<-----");
                System.out.println("----------------------------------"
                        + "-------------------------------------------");
                return;
            }
        }
    }

    /* takes last character of each row in final sorted array and creates a word with them*/
    public static String lastChars(String[] s, int size) {
        String result = "";
        for (int i = 0; i < size; i++) {
            result = result + s[i].charAt(size - 1);
        }
        return result;
    }

    /*inputs the column letter of encString as the corresponding row in array*/
    public static void moveFront(String s, String[] strings) {
        for (int i = 0; i < s.length(); i++) {
            strings[i] = s.substring(i, i + 1) + strings[i];
        }
    }

    public static void algorithmBWT() {
        Scanner in = new Scanner(System.in);
        System.out.println("Encrypt(Press 1) or Decrypt(Press 2) ");
        int startTest = in.nextInt();
        in.nextLine();

        if (startTest == 1) {
            System.out.println("Enter something you would like to encrypt: ");
            String inString = in.nextLine();

            System.out.println("Hello");

            // creating a size value to use in array
            // size will be the amount of characters in the original input
            final int SIZE = inString.length();

            // creates an array of strings, for every letter in input, there is a row in array
            String[] rotations = new String[SIZE];
            // this is to take result from lastChars
            String result = "";

            // generate the transfromation process and print first stage of transform
            genRotations(inString, rotations);
            System.out.println("Encryption process initializing:\n ");
            printArray(rotations, SIZE);

            // sorts the array of strings lexicographically and print the sorted array
            Arrays.sort(rotations);
            System.out.println("Initializing Mixer:\n");
            printArray(rotations, SIZE);

            // take last character of each sorted string to get the final transformed string
            result = lastChars(rotations, SIZE);
            System.out.println("Copy down string that is after and " +
                    "before arrows (spaces also include)\nIf you want to decode don't lose this string!");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Final string :----->" + result + "<-----");
            // getting the key to original input
            findKey(inString, rotations);

        }

        // *********************** START OF DECRYPTION CODE ***********************
        else if (startTest == 2) {
            System.out.println("Enter encrypted string: ");
            String encString = in.nextLine();
            System.out.println("Enter key value: ");
            int encKey = in.nextInt();
            // input Validation, index key must be equal to or greater than 0
            while (encKey < 0) {
                System.out.println("Your index value must be positive, Enter Index Again.");
                encKey = in.nextInt();
            }
            final int SIZE = encString.length();

            // creates a new array of strings same size as encString
            String[] revRotations = new String[SIZE];
            String result;

            // placeholder to remove null from decrypted string
            // this will make the sorted array into list which I will then print
            List<String> remNull;

            // runs once for each stage
            for (int cycles = 0; cycles < encString.length(); cycles++) {
                moveFront(encString, revRotations);
                Arrays.sort(revRotations);
                remNull = Arrays.asList(revRotations);
                System.out.println("Stage " + (cycles + 1) + "\n");
                for (int i = 0; i < SIZE; i++) {
                    String temporary = remNull.get(i);
                    int temporaryInt = temporary.length() - 4;
                    temporary = temporary.substring(0, temporaryInt);
                    System.out.println(temporary);
                }
                System.out.println();
            }
            System.out.println("Decryption complete! \n \nCheck the decoding string");
            System.out.println("| | | | | | | | | | \nV V V V V V V V V V");
            // converting to list and then printing a certain item from list
            List<String> decrypt = Arrays.asList(revRotations);
            String temp = decrypt.get(encKey);
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("At index number: " + encKey + "");
            System.out.println("The decrypted string: " + temp.substring(0, SIZE));
            System.out.println("-----------------------------------------------------------------------------");
        } else {
            System.out.println("Start me up again when you are ready to encrypt or decrypt.");
        }
    }
}
