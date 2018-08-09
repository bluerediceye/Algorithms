package com.algorithms.lintcode.amazon2018;

/**
 * Created on 08/08/2018
 *
 * @author Ming Li
 */
public class SearchMatrix {
    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     *
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        
        int start = 0;
        int end = matrix.length - 1;
        
        while (start < end - 1) {
            int middle = start + (end - start) / 2;
            if (target < matrix[middle][0]) {
                end = middle;
            } else if (target > matrix[middle][0]) {
                start = middle;
            } else {
                return true;
            }
        }
        
        int[] line;
        if (target >= matrix[end][0]) {
            line = matrix[end];
        } else if (target >= matrix[start][0]) {
            line = matrix[start];
        } else {
            return false;
        }
        
        start = 0;
        end = line.length - 1;
        
        while (start < end - 1) {
            int middle = start + (end - start) / 2;
            if (target > line[middle]) {
                start = middle;
            } else if (target < line[middle]) {
                end = middle;
            } else {
                return true;
            }
        }
        
        return target == line[start] || target == line[end];
    }
}
