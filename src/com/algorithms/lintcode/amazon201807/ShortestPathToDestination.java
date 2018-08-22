package com.algorithms.lintcode.amazon201807;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created on 12/08/2018
 *
 * @author Ming Li
 */
public class ShortestPathToDestination {
    
    private int x[] = new int[]{0, 0, -1, 1};
    private int y[] = new int[]{1, -1, 0, 0};
    
    public int shortestPath(int[][] targetMap) {
        
        if (targetMap == null || targetMap.length == 0) {
            return -1;
        }
        
        if (targetMap[0][0] == 2) {
            return 0;
        }
        
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        
        int count = 0;
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            
            while (size-- != 0) {
                Point cur = queue.poll();
                
                for (int i = 0; i < 4; i++) {
                    if (cur.x + x[i] >= targetMap[0].length || cur.y + y[i] >= targetMap.length || cur.y + y[i] < 0 || cur.x + x[i] < 0) {
                        continue;
                    }
                    
                    if (targetMap[cur.y + y[i]][cur.x + x[i]] == 1) {
                        continue;
                    }
                    
                    if (targetMap[cur.y + y[i]][cur.x + x[i]] == 0) {
                        targetMap[cur.y + y[i]][cur.x + x[i]] = 1;
                        queue.add(new Point(cur.x + x[i], cur.y + y[i]));
                    }
                    
                    if (targetMap[cur.y + y[i]][cur.x + x[i]] == 2) {
                        return count + 1;
                    }
                }
            }
            count++;
        }
        
        return -1;
    }
    
    public static class Point {
        int x, y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
