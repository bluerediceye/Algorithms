package com.algorithms.sorting;

import java.util.Random;

/**
 * Created on 09/03/2017
 *
 * @author Ming Li
 */
public class SimpleSelectionSorting {

    public static void main(String[] args) {

        int length = 20;
        int[] input = new int[length];
        for (int i = 0; i < length; i++) {
            input[i] = new Random().nextInt(length) + 1;
        }

        print(input);

        print(new SimpleSelectionSorting().sort(input));
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


        for (int i = 0; i < input.length; i++) {
            int min = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[min]) {
                    min = j;
                }
            }

           swap(input, i, min);

            print(input);
        }

        return input;
    }

    public void swap(int[] input, int a, int b){
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }
}
