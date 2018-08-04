package com.algorithms.lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 02/03/2017
 *
 * @author Ming Li
 */

public class WindowSum {

    public static void main(String[] args) {
// TODO Auto-generated method stub
        List<Integer> input = new ArrayList<Integer>();
        input.addAll(Arrays.asList(2, 3, 4, 2, 5, 7, 8, 9, 6));
        // List<Integer> input1 = new ArrayList<>();
        // input1.addAll(Arrays.asList(1,2));
        List<Integer> output = GetSum(input, 4);
        for (int i : output) System.out.print(i + " ");

        System.out.println();

        List<Integer> output2 = GetSum2(input, 4);
        for (int i : output2) System.out.print(i + " ");
    }

    public static List<Integer> GetSum(List<Integer> A, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (A == null || A.size() == 0 || k <= 0) return result;
        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            count++;
            if (count >= k) {
                int sum = 0;
                for (int j = i; j >= i - k + 1; j--) {
                    sum += A.get(j);
                }
                result.add(sum);
            }
        }
        return result;
    }

    public static List<Integer> GetSum2(List<Integer> A, int k) {
        List<Integer> result = new ArrayList<>();
        if (A == null || A.size() == 0 || k <= 0 || A.size() < k) return result;

        for (int i = 0; i < A.size(); i++) {
            if (i + k - 1 < A.size()) {
                int sum = 0;
                for (int j = i; j < k + i; j++) {
                    sum += A.get(j);
                }
                result.add(sum);
            }
        }

        return result;
    }
}
