package com.algorithms.lintcode.amazon2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created on 08/08/2018
 *
 * @author Ming Li
 */
public class UniqueSubstring {
    /**
     * @param s: a string
     * @param k: an integer
     * @return: all unique substring
     */
    public List<String> uniqueSubstring(String s, int k) {
        // Write your code here
        if(s== null || k<=0){
            return new ArrayList<>();
        }
    
        Set<String> results = new TreeSet<>();
        for(int i=0;i<s.length()-k + 1;i++){
            results.add(s.substring(i, i+k));
        }
        
        return new ArrayList<>(results);
    }
}
