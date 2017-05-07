package com.algorithms.crackingcode;

/**
 * Created on 22/03/2017
 *
 * @author Ming Li
 */
public class Matrix {


    public void setZero(int[][] matrix) {

        int row[] = new int[matrix.length];

        int column[] = new int[matrix[0].length];

        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < column.length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < column.length; j++) {
                if (row[i] == 1 || column[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int x[][] = {
                {1, 0, 4, 3, 5},
                {1, 5, 4, 1, 9},
                {1, 2, 4, 0, 8}
        };

        System.out.println("Before: ");
        print(x);

        new Matrix().setZero(x);

        System.out.println("After: ");
        print(x);

    }

    public static void print(int[][] m) {

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
}
