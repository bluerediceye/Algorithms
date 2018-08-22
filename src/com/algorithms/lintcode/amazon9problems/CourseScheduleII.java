package com.algorithms.lintcode.amazon9problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created on 09/08/2018
 *
 * @author Ming Li
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here
        int[] degrees = new int[numCourses];
        List<Integer>[] edges = new List[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            degrees[prerequisites[i][0]]++;
            if (edges[prerequisites[i][0]] == null) {
                edges[prerequisites[i][0]] = new ArrayList<Integer>();
            }
            edges[prerequisites[i][1]].add(prerequisites[0][i]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
            }
        }
        
        int count = 0;
        int[] order = new int[numCourses];
        while (!queue.isEmpty()) {
            int course = (int) queue.poll();
            order[count] = course;
            count++;
            int n = edges[course].size();
            for (int i = n - 1; i >= 0; i--) {
                int pointer = (int) edges[course].get(i);
                degrees[pointer]--;
                if (degrees[pointer] == 0) {
                    queue.add(pointer);
                }
            }
        }
        
        if (count == numCourses) {
            return order;
        }
        
        return new int[0];
    }
}
