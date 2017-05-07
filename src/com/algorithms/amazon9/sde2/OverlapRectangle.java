package com.algorithms.amazon9.sde2;

/**
 * Created on 02/03/2017
 *
 * @author Ming Li
 */
public class OverlapRectangle {


    public static void main(String[] args) {
        Point A = new Point(0, 0), B = new Point(2, 2),
                C = new Point(1, 0), D = new Point(4, 4);
        System.out.println(doOverlap(A, B, C, D));
    }

    // Returns true if two rectangles (l1, r1) and (l2, r2) overlap
    public static boolean doOverlap(Point l1, Point r1, Point l2, Point r2)
    {
        // If one rectangle is on left side of other
        if (l1.x > r2.x || l2.x > r1.x)
            return false;

        // If one rectangle is above other
        if (l1.y > r2.y || l2.y > r1.y)
            return false;

        return true;
    }

    public static class Point {
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
