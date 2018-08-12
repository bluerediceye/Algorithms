package com.algorithms.lintcode.amazon201807;

import java.util.List;

/**
 * Created on 12/08/2018
 *
 * @author Ming Li
 */
public class IntervalSearch {
    /**
     * @param intervalList: 
     * @param number: 
     * @return: return True or False
     */
    public String isInterval(List<List<Integer>> intervalList, int number) {
        
        
        if(intervalList == null || intervalList.isEmpty()){
            return "False";
        }
        
        for(List<Integer> interval : intervalList){
            if(interval.get(0) < number && interval.get(1) > number){
                return "True";
            }
        }
        
        return "False";
    }
}
