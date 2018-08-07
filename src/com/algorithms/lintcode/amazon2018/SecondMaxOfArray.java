package com.algorithms.lintcode.amazon2018;

/**
 * Created on 06/08/2018
 *
 * @author Ming Li
 */
public class SecondMaxOfArray {
    
    public static int secondMax(int[] nums){
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int max = Integer.MIN_VALUE;    
        int second = Integer.MIN_VALUE;
    
        for (int num : nums) {
            if (num > max) {
                second = max;
                max = num;
            } else if (num > second) {
                second = num;
            }
        }
        
        return second;
    }
    
    public static void main(String[] args) {
        
    }
}
