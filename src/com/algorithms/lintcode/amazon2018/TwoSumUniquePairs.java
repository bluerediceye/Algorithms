package com.algorithms.lintcode.amazon2018;

import java.util.Arrays;

/**
 * Created on 08/08/2018
 *
 * @author Ming Li
 */
public class TwoSumUniquePairs {
    /**
     * @param nums:   an array of integer
     * @param target: An integer
     *
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here
        
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        Arrays.sort(nums);
        
        int start = 0;
        int end = nums.length - 1;
        int res = 0;
        
        while (start < end) {
            int v = nums[start] + nums[end];
            if (v == target) {
                res++;
                start++;
                end--;
                while (start < end && nums[end] == nums[end + 1]) {
                    end--;
                }
                while (start < end && nums[start - 1] == nums[start]) {
                    start++;
                }
            } else if (v < target) {
                start++;
            } else {
                end--;
            }
        }
        
        return res;
    }
}
