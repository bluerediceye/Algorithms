package com.algorithms.crackingcode;

/**
 * Created on 21/03/2017
 *
 * @author Ming Li
 */
public class UniqueCharacter {
    
    public static void main(String[] args) {
        System.out.println("" + new UniqueCharacter().check("abqwerty"));
        System.out.println("" + new UniqueCharacter().check2("abqwerty"));
        System.out.println("" + new UniqueCharacter().check3("abqwerty"));
        
        System.out.println("" + new UniqueCharacter().check("apoiuytghskp"));
        System.out.println("" + new UniqueCharacter().check2("apoiuytghskp"));
        System.out.println("" + new UniqueCharacter().check3("apoiuytghskp"));
    }
    
    public boolean check(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        
        char[] chars = s.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean check2(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        
        boolean[] flags = new boolean[256];
        
        for (int i = 0; i < s.length(); i++) {
            if (flags[s.charAt(i)]) {
                return false;
            }
            flags[s.charAt(i)] = true;
        }
        
        return true;
    }
    
    public boolean check3(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        
        int checker = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if ((checker & 1 << (s.charAt(i) - 'a')) > 0) {
                return false;
            }
            checker |= 1 << (s.charAt(i) - 'a');
        }
        
        return true;
    }
}
