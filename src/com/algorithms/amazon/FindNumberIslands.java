package com.algorithms.amazon;

/**
 * Created on 20/04/2017
 *
 * @author Ming Li
 */
public class FindNumberIslands {
    
    static int[] rowMove = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] colMove = {-1, 0, 1, -1, 1, -1, 0, 1};
    
    public static void main(String[] args) {
        int M[][] = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        
        System.out.println(new FindNumberIslands().findNumberOfIslands(M));
    }
    
    public int findNumberOfIslands(int[][] matrix) {
        int count = 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    dfs(matrix, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
    
    public boolean isValidMove(int[][] matrix, int row, int col, boolean[][] visited) {
        return row >= 0 && col >= 0 && row < matrix.length && col < matrix[0].length && !visited[row][col] && matrix[row][col] == 1;
    }
    
    public void dfs(int[][] matrix, int row, int col, boolean[][] visited) {
        
        visited[row][col] = true;
        
        for (int i = 0; i < 8; i++) {
            if (isValidMove(matrix, row + rowMove[i], col + colMove[i], visited)) {
                dfs(matrix, row + rowMove[i], col + colMove[i], visited);
            }
        }
    }
}
