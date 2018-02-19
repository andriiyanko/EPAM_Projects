package main;

public class Palindrome implements Condition<String>{

    public boolean testCondtion(String obj) {
        int n = obj.length();
        for( int i = 0; i < n/2; i++ )
            if (obj.charAt(i) != obj.charAt(n-i-1)) return false;
        return true;

    }



}
