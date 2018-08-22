package com.algorithms.lintcode.amazon2018;

/**
 * Created on 07/08/2018
 *
 * @author Ming Li
 */
public class FirstUniqueCharacter {
    
    public char firstUniqChar(String str) {
        // Write your code here
        
        int[] chars = new int[256];
        
        
        for (char c : str.toCharArray()) {
            chars[c]++;
        }
        
        for (char c : str.toCharArray()) {
            if (chars[c] == 1) {
                return c;
            }
        }
        
        return '0';
    }
}
