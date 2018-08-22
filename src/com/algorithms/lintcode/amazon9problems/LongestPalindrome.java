package com.algorithms.lintcode.amazon9problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on 09/08/2018
 *
 * @author Ming Li
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null) {
            return -1;
        }
        
        Set<Character> even = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (even.contains(c)) {
                even.remove(c);
            } else {
                even.add(c);
            }
        }
        
        int remove = !even.isEmpty() ? even.size() - 1 : 0;
        
        return s.length() - remove;
    }
}
