package com.algorithms.lintcode.amazon9problems;

/**
 * Created on 07/08/2018
 *
 * @author Ming Li
 */
public class WindowSum {
    /**
     * @param nums: a list of integers.
     * @param k:    length of window.
     *
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        if(nums == null || k == 0 || nums.length==0){
            return new int[]{};
        }
    
        int[] results = new int[nums.length + 1 - k];
    
        int first = 0;
        for (int i = 0; i < k; i++) {
            first += nums[i];
        }
        results[0] = first;
    
        for (int i = 1; i < nums.length - k + 1; i++) {
            int tmp = results[i - 1] + nums[i+k-1] - nums[i - 1];
            results[i] = tmp;
        }
        return results;
    }
}
