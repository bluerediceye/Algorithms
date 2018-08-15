package com.algorithms.lintcode.amazon.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 15/08/2018
 *
 * @author Ming Li
 */
public class Subsets {
    
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0){
            List<List<Integer>> r = new ArrayList<>();
            r.add(new ArrayList<>());
            return r;
        }
        
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        
        helper(new ArrayList<>(), 0, nums, results);
        
        return results;
    }
    
    void helper(List<Integer> selected, int start, int[] nums, List<List<Integer>> results){
        results.add(selected);
        
        for(int i = start;i<nums.length;i++){
            List<Integer> newSelected= new ArrayList<>(selected);
            newSelected.add(nums[i]);
            helper(newSelected, i + 1, nums, results);
        }
    }
}
