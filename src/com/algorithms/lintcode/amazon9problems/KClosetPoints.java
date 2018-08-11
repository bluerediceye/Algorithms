package com.algorithms.lintcode.amazon9problems;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created on 09/08/2018
 *
 * @author Ming Li
 */
public class KClosetPoints {
    class Point {
        int x;
        int y;
        
        Point() {
            x = 0;
            y = 0;
        }
        
        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
    
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here
        PriorityQueue<Point> pq = new PriorityQueue<>(k, (a, b) -> {
            int diff = getDistance(b, origin) - getDistance(a, origin);
            if (diff == 0) {
                diff = b.x - a.x;
            }
            if (diff == 0) {
                diff = b.y - a.y;
            }
            return diff;
        });
    
        for (Point point : points) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        k = pq.size();
        Point[] ret = new Point[k];
        while (!pq.isEmpty()) {
            ret[--k] = pq.poll();
        }
        return ret;
    }
    
    private int getDistance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
}
