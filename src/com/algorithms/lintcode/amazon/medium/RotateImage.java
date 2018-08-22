package com.algorithms.lintcode.amazon.medium;

/**
 * Created on 17/08/2018
 *
 * @author Ming Li
 */
public class RotateImage {
    
    /**
     * [
     * [1,2,3,a,b,c],
     * [4,5,6,d,e,f],
     * [7,8,9,g,h,k]
     * [x,y,z,n,m,o]
     * ]
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        int length = matrix.length;
        
        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < (length + 1) / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][i];
                matrix[length - j - 1][i] = matrix[length - i - 1][length - j - 1];
                matrix[length - i - 1][length - j - 1] = matrix[j][length - i - 1];
                matrix[j][length - i - 1] = tmp;
            }
        }
    }
}
