package com.algorithms.lintcode.amazon.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created on 15/08/2018
 *
 * @author Ming Li
 */
public class ThreeSum {
    
    public List<List<Integer>> threeSum(int[] nums) {
        int size = nums.length;
        Set<Triplet> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if (i != j && j != k && i != k) {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            set.add(new Triplet(i, j, k));
                        }
                    }
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        
        for(Triplet triplet: set){
            List<Integer> tmp = new ArrayList<>();
            tmp.add(triplet.a);
            tmp.add(triplet.b);
            tmp.add(triplet.c);
            res.add(tmp);
        }
        
        return res;
    }
    
    public static class Triplet {
        int a, b, c;
        
        public Triplet(int a, int b, int c) {
            int[] tmp = new int[]{a, b, c};
            Arrays.sort(tmp);
            
            this.a = tmp[0];
            this.b = tmp[1];
            this.c = tmp[2];
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            
            Triplet triplet = (Triplet) o;
            
            if (a != triplet.a) {
                return false;
            }
            if (b != triplet.b) {
                return false;
            }
            return c == triplet.c;
        }
        
        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + b;
            result = 31 * result + c;
            return result;
        }
    }
    
    
}
