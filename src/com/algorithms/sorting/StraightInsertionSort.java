package com.algorithms.sorting;

import java.util.Random;

/**
 * Created on 09/03/2017
 *
 * @author Ming Li
 */
public class StraightInsertionSort {
    
    public static void main(String[] args) {
        
        int length = 20;
        int[] input = new int[length];
        for (int i = 0; i < length; i++) {
            input[i] = new Random().nextInt(length) + 1;
        }
        
        print(input);
        
        print(new StraightInsertionSort().sort(input));
    }
    
    public static void print(int[] input) {
        for (int i : input) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    public int[] sort(int[] input) {
        for (int i = 1; i < input.length; i++) {
            
            if (input[i] < input[i - 1]) {
                int x = input[i];
                int j = i - 1;
                
                while (j >= 0 && x < input[j]) {
                    input[j + 1] = input[j];
                    j--;
                }
                input[j + 1] = x;
            }
            
            print(input);
        }
        return input;
    }
}
