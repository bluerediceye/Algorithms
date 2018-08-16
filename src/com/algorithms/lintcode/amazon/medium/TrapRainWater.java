package com.algorithms.lintcode.amazon.medium;

/**
 * Created on 16/08/2018
 *
 * @author Ming Li
 */
public class TrapRainWater {
    public int trapRainWater(int[] heights) {
        // write your code here
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int[] leftMax = new int[heights.length];
        leftMax[0] = heights[0];
        int[] rightMax = new int[heights.length];
        rightMax[heights.length - 1] = heights[heights.length - 1];
        for (int i = 1; i < heights.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], heights[i]);
        }
        for (int i = heights.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], heights[i]);
        }
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - heights[i];
        }
        return res;
    }
}
