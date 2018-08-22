package com.algorithms.amazon;

/**
 * Created on 20/04/2017
 *
 * @author Ming Li
 */
public class MinCostPath {
    
    public static int minCostPath(int[][] cost, int m, int n) {
        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }
        if (m == 0 && n == 0) {
            return cost[m][n];
        }
        return cost[m][n] + min(minCostPath(cost, m - 1, n), minCostPath(cost, m, n - 1), minCostPath(cost, m - 1, n - 1));
    }
    
    private static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
    
    public static void main(String[] args) {
        int cost[][] = {{1, 2, 3}, {4, 8, 2}, {1, 5, 3}};
        
        System.out.println(minCostPath(cost, 2, 2));
        System.out.println(minCostPathDP(cost, 2, 2));
        
        int cost2[][] = {{4, 2, 3, 9}, {8, 4, 2, 7}, {9, 3, 13, 12}};
        System.out.println(minCostPath(cost2, 2, 2));
        System.out.println(minCostPathDP(cost2, 2, 2));
        
    }
    
    public static int minCostPathDP(int[][] cost, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = cost[0][0];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + cost[i][0];
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + cost[0][j];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = cost[i][j] + min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]);
            }
        }
        return dp[m][n];
    }
}
