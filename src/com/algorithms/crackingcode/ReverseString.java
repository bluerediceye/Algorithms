package com.algorithms.crackingcode;

/**
 * Created on 21/03/2017
 *
 * @author Ming Li
 */
public class ReverseString {
    
    public static void main(String[] args) {
        System.out.println(new ReverseString().reverse("helloworld"));
        System.out.println(new ReverseString().reverse("helloworld".toCharArray()));
    }
    
    public String reverse(String s) {
        
        
        if (s == null || s.length() <= 1) {
            return s;
        }
        
        char[] reversed = new char[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            reversed[i] = s.charAt(s.length() - 1 - i);
        }
        
        
        return new String(reversed);
    }
    
    public char[] reverse(char[] s) {
        if (s == null || s.length <= 1) {
            return s;
        }
        
        
        for (int i = 0; i < (s.length >> 1); i++) {
            char temp = s[s.length - 1 - i];
            s[s.length - 1 - i] = s[i];
            s[i] = temp;
        }
        return s;
    }
}
