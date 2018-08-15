package com.algorithms.lintcode.amazon.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created on 15/08/2018
 *
 * @author Ming Li
 */
public class TopKFrequentWords {
    
    public String[] topKFrequentWords(String[] words, int k) {
    
        if(words == null || words.length == 0 || words.length < k || k == 0){
            return new String[]{};
        }
    
        Map<String, Integer> map = new HashMap<>(words.length);
        for(String word: words){
            map.putIfAbsent(word, 1);
            map.put(word, map.get(word) + 1);
        }
    
        PriorityQueue<Pair> queue = new PriorityQueue<>(k, comparator);
        for(Map.Entry<String, Integer> entry:map.entrySet()){
            Pair pair = new Pair(entry.getKey(), entry.getValue());
            if(queue.size() < k){
                queue.add(pair);
            } else {
                if(comparator.compare(queue.peek(), pair) < 0){
                    queue.poll();
                    queue.add(pair);
                }
            }
        }
        
        String[]results =new String[queue.size()];
        for(int i=queue.size() -1;i>=0;i--){
            results[i] = queue.poll().val;
        }
        
        return results;
    }
    
    private Comparator<Pair> comparator = new Comparator<Pair>() {
        @Override
        public int compare(Pair o1, Pair o2) {
            int diff = o1.count - o2.count;
            if(diff == 0){
                return o2.val.compareTo(o1.val);
            } else{
                return diff;
            }
        }
    };
    
    public static class Pair {
        String val;
         int count;
         public Pair(String val, int count){
             this.val = val;
             this.count = count;
         }
    }
    
    public static void main(String[] args) {
        String[] x= new TopKFrequentWords().topKFrequentWords(new String[]{"yes","lint","code","yes","code","baby","you","baby","chrome","safari","lint","code","body","lint","code"}, 3);
        for(String s: x){
            System.out.println(s);
        }
    }
}
