package com.algorithms.amazon9.sde2;

import java.util.*;

/**
 * Created on 02/03/2017
 *
 * @author Ming Li
 */
public class kNearestPoint {

    public static void main(String[] args) {
        Point origin = new Point(0,0);
        Point a = new Point(1,2);
        Point b = new Point(3,2);
        Point c = new Point(1,0);
        Point d = new Point(4,3);
        Point e = new Point(2,3);
        Point[] points = (Point[]) Arrays.asList(a, b,c,d,e).toArray();

        Point[] results = Solution(points, origin, 4);

        for(Point point : results) {
            System.out.print("(" + point.x + "," + point.y + ") ");
        }
    }



    public static Point[] Solution(Point[] array, final Point origin, int k) {
        Point[] rvalue = new Point[k];
        int index = 0;
        PriorityQueue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                return (int) (getDistance(b, origin) - getDistance(a, origin));
            }
        });

        for (int i = 0; i < array.length; i++) {
            pq.offer(array[i]);
            if (pq.size() > k)
                pq.poll();
        }
        while (!pq.isEmpty())
            rvalue[index++] = pq.poll();
        return rvalue;
    }

    private static double getDistance(Point a, Point b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }

    //
    public List<Point> findKClosest(Point[] p, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<Point>(10, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                return (b.x * b.x + b.y * b.y) - (a.x * a.x + a.y * a.y);
            }
        });

        for (int i = 0; i < p.length; i++) {
            if (i < k)
                pq.offer(p[i]);
            else {
                Point tmp = pq.peek();
                if ((p[i].x * p[i].x + p[i].y * p[i].y) - (tmp.x * tmp.x + tmp.y * tmp.y) < 0) {
                    pq.poll();
                    pq.offer(p[i]);
                }
            }
        }

        List<Point> x = new ArrayList<Point>();
        while (!pq.isEmpty())
            x.add(pq.poll());

        return x;
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
