package com.algorithms.lintcode.amazon2018;

/**
 * Created on 08/08/2018
 *
 * @author Ming Li
 */
public class Search2DMatrixII {
    /**
     * [
     * [1, 3, 5, 7],
     * [2, 4, 7, 8],
     * [3, 5, 9, 10]
     * ]
     *
     * @param matrix
     * @param target
     *
     * @return
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int x = matrix.length - 1;
        int y = 0;
        int yLength = matrix[0].length;
        int count = 0;
        while (x >= 0 && y < yLength) {
            int v = matrix[x][y];
            if (v > target) {
                x--;
            } else if (v < target) {
                y++;
            } else {
                x--;
                y++;
                count++;
            }
        }
        
        return count;
    }
}
