package com.algorithms.lintcode.amazon2018;

import java.util.Arrays;

/**
 * Created on 06/08/2018
 *
 * @author Ming Li
 */
public class ClosetTargetValue {
    
    public static void main(String[] args) {
        
    }
    
    public int closestTargetValue(int target, int[] array) {
        if (array == null) {
            return -1;
        }
        Arrays.sort(array);
        int i = 0;
        int j = array.length - 1;
        int res = Integer.MIN_VALUE;
        while (i < j) {
            
            while (i < j && array[j] + array[i] > target) {
                j--;
            }
            
            while (i < j && array[j] + array[i] <= target) {
                if (array[j] + array[i] > res) {
                    res = array[j] + array[i];
                }
                i++;
            }
        }
        
        return res == Integer.MIN_VALUE ? -1 : res;
    }
}
