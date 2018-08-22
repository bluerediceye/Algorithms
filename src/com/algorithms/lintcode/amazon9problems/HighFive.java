package com.algorithms.lintcode.amazon9problems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created on 09/08/2018
 *
 * @author Ming Li
 */
public class HighFive {
    /**
     * @param results a list of <student_id, score>
     *
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        
        Map<Integer, Double> ans = new HashMap<>();
        Map<Integer, PriorityQueue<Integer>> tmp = new HashMap<>();
        
        for (Record r : results) {
            if (!tmp.containsKey(r.id)) {
                tmp.put(r.id, new PriorityQueue<>());
            }
            tmp.get(r.id).add(r.score);
            
            if (tmp.get(r.id).size() > 5) {
                tmp.get(r.id).poll();
            }
        }
        
        for (Map.Entry<Integer, PriorityQueue<Integer>> e : tmp.entrySet()) {
            int sum = 0;
            while (!e.getValue().isEmpty()) {
                sum += e.getValue().poll();
            }
            ans.put(e.getKey(), ((double) sum / 5));
        }
        
        return ans;
    }
    
    class Record {
        public int id, score;
        
        public Record(int id, int score) {
            this.id = id;
            this.score = score;
        }
    }
}
