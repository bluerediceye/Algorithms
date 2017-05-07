package com.algorithms.amazon9.sde1;

@SuppressWarnings("ForLoopReplaceableByForEach")
public class RotateMetrics90Degree {

    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    public static void main(String[] args) {

        int [][] metrics = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,8,7,6}
        };

        println(metrics);

        println(resolve(metrics, RIGHT));

        println(resolve(metrics, LEFT));
    }

    public static int[][] resolve(int[][] input, int flag){
        if(input == null || input.length == 0){
            return input;
        }

        int row = input.length;
        int column = input[0].length;
        int[][] output = new int[column][row];

        if(flag == RIGHT){
            int dstColumn = row - 1;
            for(int i=0;i<row;i++, dstColumn--){
                for(int j=0;j<column;j++){
                    output[j][dstColumn] = input[i][j];
                }
            }
        }

        if(flag == LEFT){
            for(int i=0;i<row;i++){
                for(int j=0;j<column;j++){
                    output[column-1-j][i] = input[i][j];
                }
            }
        }

        return output;
    }

    public static void println(int[][] metrics){
        if(metrics != null){
            for(int i=0;i<metrics.length;i++){
                for(int j=0;j<metrics[0].length;j++){
                    System.out.print(metrics[i][j]);
                }
                System.out.println();
            }
        }
        System.out.println();
    }
}
