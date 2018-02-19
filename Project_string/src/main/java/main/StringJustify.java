package main;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class StringJustify extends Format {

    private static final long serialVersionUID = 1L;

    public enum Alignment {
        LEFT, CENTER, RIGHT,
    }

    private Alignment currentAlignment;
    private int maxChars;

    public StringJustify(int maxChars, Alignment alignment) {
        switch (alignment) {
            case LEFT:
            case CENTER:
            case RIGHT:
                this.currentAlignment = alignment;
                break;
            default:
                throw new IllegalArgumentException("invalid justify argument!");
        }
        if (maxChars < 0) {
            throw new IllegalArgumentException("maxChars must be bigger than 0!");
        }
        this.maxChars = maxChars;

    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
        String s = obj.toString();
        List<String> strings = splitInputStrings(s);
        ListIterator<String> listIterator = strings.listIterator();

        while (listIterator.hasNext()) {
            String input = listIterator.next();

            //get the spaces in the right places
            switch (currentAlignment) {
                case RIGHT:
                    padding(toAppendTo, maxChars - input.length());
                    toAppendTo.append(input);
                    break;
                case CENTER:
                    int toAdd = maxChars - input.length();
                    padding(toAppendTo, toAdd / 2);
                    toAppendTo.append(input);
                    padding(toAppendTo, toAdd - toAdd / 2);
                    break;
                case LEFT:
                    toAppendTo.append(input);
                    padding(toAppendTo, maxChars - input.length());
                    break;
            }
            toAppendTo.append("\n");
        }
        return toAppendTo;
    }

    public Object parseObject(String source, ParsePosition pos) {
        return source;
    }

    public final void padding(StringBuffer to, int howMany) {
        for (int i = 0; i < howMany; i++) {
            to.append(' ');

        }
    }

    private List<String> splitInputStrings(String string) {
        List<String> list = new ArrayList<String>();
        if (string == null) {
            return list;
        }
        for (int i = 0; i < string.length(); i += maxChars) {
            int endIndex = Math.min(i + maxChars, string.length());
            list.add(string.substring(i, endIndex));
        }
        return list;
    }

    public static void textJustify() {
        String alignment;
        int maxChars;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the aligment (L:Left,R:Right,C:Center ) : ");
        alignment = sc.nextLine();
        System.out.print("Enter maxChars: ");
        maxChars = sc.nextInt();
        System.out.println("Input the text:");
        StringBuilder text = new StringBuilder();

        while (sc.hasNextLine()) {
            text.append(sc.nextLine()).append(System.getProperty("line.separator"));
        }
        sc.close();

        if (alignment.equalsIgnoreCase("l")) {
            StringJustify stringJustify = new StringJustify(maxChars, StringJustify.Alignment.LEFT);
            System.out.println(stringJustify.format(text));
        }
        if (alignment.equalsIgnoreCase("c")) {
            StringJustify stringJustify = new StringJustify(maxChars, Alignment.CENTER);
            System.out.println(stringJustify.format(text));
        }
        if (alignment.equalsIgnoreCase("r")) {
            StringJustify stringJustify = new StringJustify(50, Alignment.RIGHT);
            System.out.println(stringJustify.format(text));
        }


    }
}
