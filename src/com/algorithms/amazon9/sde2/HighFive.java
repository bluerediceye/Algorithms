package com.algorithms.amazon9.sde2;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created on 02/03/2017
 *
 * @author Ming Li
 */
public class HighFive {
    public static Map<Integer, Double> getHighFive(Result[] results)
    {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(Result itr: results)
        {
            if(!map.containsKey(itr.id))
            {
                map.put(itr.id, new PriorityQueue<Integer>());
                map.get(itr.id).offer(itr.value);
            }
            else
            {
                if(map.get(itr.id).size() < 5) map.get(itr.id).offer(itr.value);
                else if(itr.value > map.get(itr.id).peek())
                {
                    map.get(itr.id).poll();
                    map.get(itr.id).offer(itr.value);
                }
            }
        }
        Map<Integer, Double> res = new HashMap<>();
        for(int id: map.keySet())
        {
            int sum = 0;
            PriorityQueue<Integer> q = map.get(id);
            while(!q.isEmpty()) sum += q.poll();
            res.put(id, (sum + 0.0) / 5);
        }
        return res;
    }

    public static void main(String[] args) {
        Result r1 = new Result(1, 95);
        Result r2 = new Result(1, 95);
        Result r3 = new Result(1, 91);
        Result r4 = new Result(1, 91);
        Result r5 = new Result(1, 93);
        Result r6 = new Result(1, 105);
        Result r7 = new Result(2, 6);
        Result r8 = new Result(2, 6);
        Result r9 = new Result(2, 7);
        Result r10 = new Result(2, 6);
        Result r11 = new Result(2, 6);
        Result[] arr = {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
        Map<Integer, Double> res = getHighFive(arr);
        System.out.println(res.get(1) + " " +res.get(2));
    }


    static class Result{
        int id;
        int value;
        public Result(int id, int value){
            this.id = id;
            this.value = value;
        }
    }
}
