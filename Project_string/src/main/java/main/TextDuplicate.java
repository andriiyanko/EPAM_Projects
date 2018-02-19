package main;

import java.util.Scanner;

public class TextDuplicate {

   public static void deleteDuplicates(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Inpur the text:");
        StringBuilder text = new StringBuilder();
        String output = "";

        while (sc.hasNextLine()) {
            text.append(sc.nextLine()).append(System.getProperty("line.separator"));
            for (int i = 0; i < text.length(); i++) {
                if (i == 0) {
                    output = "" + text.charAt(i);
                } else {
                    if (text.charAt(i - 1) != text.charAt(i)) {
                        output += text.charAt(i);
                    }
                }

            }
        }
        sc.close();

        System.out.println();
        System.out.println("Output text after removing: ");
        System.out.println(output);
    }
}
