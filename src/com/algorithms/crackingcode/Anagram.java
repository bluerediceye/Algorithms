package com.algorithms.crackingcode;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created on 22/03/2017
 *
 * @author Ming Li
 */
public class Anagram {
    
    public static void main(String[] args) {
        System.out.println("Is equal: " + new Anagram().check("hello", "lloeh"));
        System.out.println("Is equal: " + new Anagram().check("hello", "llfoeh"));
    }
    
    public boolean check(String a, String b) {
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        Arrays.sort(aa);
        Arrays.sort(bb);
        String aaa = new String(aa);
        String bbb = new String(bb);
        
        return Objects.equals(aaa, bbb);
    }
}
