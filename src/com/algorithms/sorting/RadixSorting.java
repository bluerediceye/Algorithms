package com.algorithms.sorting;

import java.util.Random;

/**
 * Created on 17/04/2017
 *
 * @author Ming Li
 */
public class RadixSorting {


    public int[] sort(int[] input){
        int max = getMax(input);


        for(int exp = 1;(max/exp) > 0; exp*=10){
            subRoutine(input, exp);
        }


        return input;
    }

    public int[] subRoutine(int[] input, int exp){

        int[] tmp = new int[input.length];
        int[] count = new int[10];

        for(int i=0;i<input.length;i++){
            count[(input[i]/exp)%10]++;
        }

        for(int i=1;i<count.length;i++){
            count[i] = count[i] + count[i-1];
        }

        for(int i=input.length - 1 ;i>=0;i--){
            tmp[count[(input[i]/exp)%10] - 1] = input[i];
            count[(input[i]/exp)%10]--;
        }

        for(int i=0;i<input.length;i++){
            input[i] = tmp[i];
        }

        return input;
    }

    public int getMax(int[] input){
        int max = input[0];

        for(int i = 0;i<input.length ;i++){
            if(max<input[i]){
                max = input[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {

        int length = 10;
        int[] input = new int[length];
        for (int i = 0; i < length; i++) {
            input[i] = new Random().nextInt(length) + 1;
        }

        print(input);

        print(new RadixSorting().sort(new int[]{5,7,3,4,6,9,8,10}));
    }

    public static void print(int[] input) {
        for (int i : input) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
