package com.algorithms.sorting;

import java.util.Random;

/**
 * Created on 09/03/2017
 *
 * @author Ming Li
 */
public class BubbleSorting {
    
    
    public static void main(String[] args) {
        
        int length = 20;
        int[] input = new int[length];
        for (int i = 0; i < length; i++) {
            input[i] = new Random().nextInt(length) + 1;
        }
        
        print(input);
        
        print(new BubbleSorting().sort(input));
    }
    
    public static void print(int[] input) {
        for (int i : input) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    public int[] sort(int[] input) {
        
        if (input == null || input.length <= 1) {
            return input;
        }
        
        for (int i = 0; i < input.length; i++)
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j] >= input[j + 1]) {
                    int temp = input[j + 1];
                    input[j + 1] = input[j];
                    input[j] = temp;
                    print(input);
                }
            }
        
        return input;
    }
}
