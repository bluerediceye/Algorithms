package com.algorithms.sorting;

import java.util.Random;

/**
 * Created on 16/04/2017
 *
 * @author Ming Li
 */
public class BucketSorting {

    public int[] sort(int[] input, int MAX) {
        if(input == null || input.length <=1) return input;


        int[] bucket = new int[MAX];

        for(Integer i : input){
            bucket[i] = bucket[i] + 1;

        }

        int k = 0;
        for(int i = 0; i<bucket.length;i++){
            for(int j=0;j<bucket[i];j++){
                input[k++] = i;
            }
        }

        return input;
    }

    public static void main(String[] args) {

        int length = 20;
        int[] input = new int[length];
        for (int i = 0; i < length; i++) {
            input[i] = new Random().nextInt(length) + 1;
        }

        print(input);

        print(new BucketSorting().sort(input, length + 1));
    }

    public static void print(int[] input) {
        for (int i : input) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
