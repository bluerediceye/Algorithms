package com.algorithms.lintcode.amazon2018;

/**
 * Created on 07/08/2018
 *
 * @author Ming Li
 */
public class ClimbingStairII {
    /**
     * @param n: An integer
     * @return: An Integer
     */
    public static int climbStairs2(int n) {
        // write your code here
        
        int[] results = new int[n+1];
        results[0] = 1;
        for(int i=1;i<=n;i++){
            for(int j =1 ;j<=3;j++){
                if(i>=j){
                    results[i] += results[i-j];
                }
            }
        }
        return results[n];
    }
    
    public static void main(String[] args) {
        System.out.println(climbStairs2(4));
    }
}
