package com.algorithms.lintcode.amazon.medium;

import java.util.Set;

/**
 * Created on 16/08/2018
 *
 * @author Ming Li
 */
public class WordBreak {
    
    public boolean wordBreak(String s, Set<String> dict) {
        
        if (s == null || s.isEmpty() || dict == null || dict.isEmpty()) {
            return false;
        }
        
        boolean[] canBreak = new boolean[s.length() + 1];
        canBreak[0] = true;
        int maxLength = getMaxLength(dict);
        for (int i = 1; i < s.length(); i++) {
            for (int j = 1; j <= maxLength; j++) {
                String word = s.substring(i - j, i);
                if (canBreak[i - j] && dict.contains(word)) {
                    canBreak[i] = true;
                }
            }
        }
        
        return canBreak[s.length()];
    }
    
    private int getMaxLength(Set<String> set) {
        int max = 0;
        for (String s : set) {
            max = Math.max(max, s.length());
        }
        return max;
    }
}
