package com.algorithms.lintcode.amazon2018;

/**
 * Created on 06/08/2018
 *
 * @author Ming Li
 */
public class DotProduct {
    public static int dotProduct(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0 || A.length != B.length) {
            return -1;
        }
        
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += (A[i] * B[i]);
        }
        return sum;
    }
}
