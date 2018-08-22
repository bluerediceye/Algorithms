package com.algorithms.sorting;

import java.util.Random;

/**
 * Created on 13/03/2017
 *
 * @author Ming Li
 */
public class MergingSorting {
    
    
    public static void main(String[] args) {
        
        int length = 20;
        int[] input = new int[20];
        for (int i = 0; i < length; i++) {
            input[i] = new Random().nextInt(length) + 1;
        }
        
        print(input);
        
        print(new MergingSorting().sort(input));
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
        
        return mergeSort(input, 0, input.length - 1, new int[input.length]);
        
        
    }
    
    public int[] mergeSort(int[] a, int first, int last, int[] temp) {
        
        
        if (first < last) {
            int middle = (first + last) / 2;
            
            mergeSort(a, first, middle, temp);
            mergeSort(a, middle + 1, last, temp);
            mergeArray(a, first, middle, last, temp);
            print(a);
        }
        
        return a;
        
        
    }
    
    private int[] mergeArray(int a[], int first, int middle, int last, int[] temp) {
        
        int i = first;
        int j = middle + 1;
        int k = 0;
        
        while (i <= middle && j <= last) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        
        while (i <= middle) {
            temp[k++] = a[i++];
        }
        
        while (j <= last) {
            temp[k++] = a[j++];
        }
        
        for (int q = 0; q < k; q++) {
            a[first + q] = temp[q];
        }
        
        return a;
    }
}
