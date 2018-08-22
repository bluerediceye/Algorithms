package com.algorithms.lintcode.amazon201807;

/**
 * Created on 11/08/2018
 *
 * @author Ming Li
 */
public class ModernLudoI {
    public static void main(String[] args) {
        int[][] input = new int[][]{{7, 9}, {8, 14}};
        int[][] input2 = new int[][]{};
        int[][] input3 = new int[][]{{77, 36}, {54, 8}, {42, 5}, {37, 31}, {36, 10}, {66, 15}, {58, 68}};
        ;
        
        int r = new ModernLudoI().modernLudo(86, input3);
        System.out.println("result: " + r);
    }
    
    /**
     * @param length:      the length of board
     * @param connections: the connections of the positions
     *
     * @return: the minimum steps to reach the end
     */
    public int modernLudo(int length, int[][] connections) {
        if (length < 7) {
            return 1;
        }
        
        int[] f = new int[length + 1];
        int[] dp = new int[length + 1];
        
        for (int i = 1; i <= length; i++) {
            f[i] = i;
            dp[i] = Integer.MAX_VALUE;
        }
        
        for (int[] connection : connections) {
            f[connection[0]] = connection[1];
        }
        
        dp[1] = 0;
        for (int i = 2; i <= length; i++) {
            if (i < 8) {
                dp[i] = 1;
            } else {
                for (int j = i - 1; j > i - 7; j--) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
            dp[f[i]] = Math.min(dp[i], dp[f[i]]);
        }
        return dp[length];
    }
}
