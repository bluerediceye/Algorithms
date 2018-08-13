package com.algorithms.lintcode.amazon201807;

import java.util.Arrays;

/**
 * Created on 13/08/2018
 *
 * @author Ming Li
 */
public class TwoSum {
    public int twoSum5(int[] nums, int target) {
        // Write your code here
        
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        Arrays.sort(nums);
        int end = nums.length - 1;
        int count = 0;
        for (int i = end; i > 0; i--) {
            int k = i - 1;
            while (k >= 0 && nums[i] + nums[k] > target) {
                k--;
            }
            count += k + 1;
        }
        
        return count;
    }
    
    public int twoSum5_2(int[] nums, int target) {
        // Write your code here
        
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        
        while (left < right) {
            if (nums[left] + nums[right] <= target) {
                count += right - left;
                left++;
            }
            else {
                right--;
            }
        }
        
        return count;
    }
}
