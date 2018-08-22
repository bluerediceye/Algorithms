package com.algorithms.lintcode.amazon2018;

/**
 * Created on 07/08/2018
 *
 * @author Ming Li
 */

public class RectangleOverlap {
    public boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
        // write your code here
        
        if (l1.y < r2.y) {
            return false;
        }
        if (r1.y > l2.y) {
            return false;
        }
        
        if (l1.x > r2.x) {
            return false;
        }
        
        if (r1.x < l2.x) {
            return false;
        }
        
        return true;
    }
    
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
}
