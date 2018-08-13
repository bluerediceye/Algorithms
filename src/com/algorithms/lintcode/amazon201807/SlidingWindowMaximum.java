package com.algorithms.lintcode.amazon201807;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created on 13/08/2018
 *
 * @author Ming Li
 */
public class SlidingWindowMaximum {
    /**
     * @param nums: A list of integers.
     * @param k:    An integer
     *
     * @return: The maximum number inside the window at each moving.
     */
    private void inQueue(Deque<Integer> deque, int num) {
        while (!deque.isEmpty() && deque.peekLast() < num) {
            deque.pollLast();
        }
        deque.offer(num);
    }
    
    private void outQueue(Deque<Integer> deque, int num) {
        if (deque.peekFirst() == num) {
            deque.pollFirst();
        }
    }
    
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Deque<Integer> deque = new ArrayDeque<Integer>();
        if (nums.length == 0) {
            return ans;
        }
        for (int i = 0; i < k - 1; i++) {
            inQueue(deque, nums[i]);
        }
        
        for(int i = k - 1; i < nums.length; i++) {
            inQueue(deque, nums[i]);
            ans.add(deque.peekFirst());
            outQueue(deque, nums[i - k + 1]);
        }
        return ans;
        
    }
    
    public static void main(String[] args) {
        List<Integer> r = new SlidingWindowMaximum().maxSlidingWindow(new int[]{1,2,7,7,2},4);
        System.out.println(r);
    }
}
