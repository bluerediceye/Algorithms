package com.algorithms.lintcode.amazon2018;

/**
 * Created on 07/08/2018
 *
 * @author Ming Li
 */
public class ValidAnagram {
    /**
     * @param s: The first string
     * @param t: The second string
     * @return: true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        
        if(s== null || t== null){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }
        
        int[] a = new int[256];
        int[] b = new int[256];
        
        for(char c: s.toCharArray()){
            a[c]++;
        }
    
        for(char c: t.toCharArray()){
            b[c]++;
        }
        
        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i]){
                return false;
            }
        }
        return true;
    }
}
