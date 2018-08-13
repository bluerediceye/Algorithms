package com.algorithms.lintcode.amazon201807;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created on 12/08/2018
 *
 * @author Ming Li
 */
public class UniqueSubstring {
    
    
    public List<String> uniqueSubstring(String s, int k) {
        if(s==null||s.isEmpty() || k == 0){
            return new ArrayList<>();
        }
    
        Set<String> res = new TreeSet<>();
        for(int i=0;i<s.length() - k + 1;i++){
            res.add(s.substring(i, i+k));
        }
        
        return new ArrayList<>(res);
    }
}
