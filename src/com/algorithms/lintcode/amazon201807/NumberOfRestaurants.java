package com.algorithms.lintcode.amazon201807;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created on 12/08/2018
 *
 * @author Ming Li
 */
public class NumberOfRestaurants {
    
    public static List<List<Integer>> nearestRestaurant(List<List<Integer>> restaurant, int n) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(restaurant == null||restaurant.isEmpty()||n > restaurant.size()){
            return result;
        }
        int L = restaurant.size();
        int []distance = new int[L];
        for(int i=0; i<L;i++){
            int x = restaurant.get(i).get(0);
            int y = restaurant.get(i).get(1);
            int dis = x*x + y*y;
            distance[i] = dis;
        }
        Arrays.sort(distance);
        int count = 0;
        for (List<Integer> aRestaurant : restaurant) {
            int x = aRestaurant.get(0);
            int y = aRestaurant.get(1);
            int dis = x * x + y * y;
            if (dis <= distance[n - 1]) {
                result.add(aRestaurant);
                count++;
            }
            if (count == n) {
                break;
            }
        }
        return result;
    }
}
