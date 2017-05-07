package com.algorithms.sorting;

import java.util.Random;

/**
 * Created on 13/03/2017
 *
 * @author Ming Li
 */
public class QuickSorting {


    public int[] sort(int[] input, int left, int right) {
        if (left > right) {
            return input;
        }

        int storeIndex = partition(input, left, right);

        sort(input, left, storeIndex - 1);
        sort(input, storeIndex + 1, right);

        return input;
    }

    private static void swap(int[] input, int a, int b){
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

    private int partition(int[] input, int left, int right) {
        int storeIndex = left;
        int pivot = input[right];
        for (int i = left; i <= right; i++) {
            if (input[i] < pivot) {
                swap(input, storeIndex, i);
                storeIndex++;
            }
        }
        swap(input, right, storeIndex);
        return storeIndex;
    }

    public static void main(String[] args) {

        int length = 20;
        int[] input = new int[length];
//        int[] input = new int[]{1,3,2};
        for (int i = 0; i < input.length; i++) {
            input[i] = new Random().nextInt(input.length) + 1;
        }

        print(input);

        print(new QuickSorting().sort(input, 0, input.length -1));

        print(QuickSorting.quickSort(input, 0, input.length -1));

        print(QuickSorting.quickSort2(input, 0, input.length -1));
    }

    public static void print(int[] input) {
        for (int i : input) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] quickSort(int[] input, int start, int end){

        if(input == null || input.length <=1 || start >= end){
            return input;
        }

        int index = quickPartition(input, start, end);
        quickSort(input, start, index-1);
        quickSort(input, index + 1, end);
        return input;
    }

    public static int[] quickSort2(int[] input, int start, int end){

        if(input == null || input.length <=1 || start >= end) return input;


        int index = quickPartition2(input, start, end);
        quickSort2(input, start, index -1);
        quickSort2(input, index + 1, end);
        return input;
    }

    private static int quickPartition2(int[] input, int start, int end){

        int storeIndex = start;
        int pivot = input[end];

        for(int i=start;i<=end;i++){
            if(input[i] < pivot){
                swap(input, i, storeIndex);
                storeIndex++;
            }
        }
        swap(input, storeIndex, end);

        return storeIndex;
    }

    private static int quickPartition(int[] input, int start, int end) {

        int pivot = input[start];

        while(start < end){
            while(start<end && input[end] > pivot){
                end--;
            }

            if(start < end){
                input[start++] = input[end];
            }

            while(start<end && input[start] < pivot){
                start++;
            }

            if(start < end){
                input[end--] = input[start];
            }
        }
        input[start] = pivot;
        return start;
    }
}
