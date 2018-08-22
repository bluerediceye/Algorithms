package com.algorithms.lintcode.amazon2018;

/**
 * Created on 06/08/2018
 *
 * @author Ming Li
 */
public class CanReachTheEndpoint {
    
    private static int[] xd = {0, 0, -1, 1};
    private static int[] yd = {1, -1, 0, 0};
    
    
    public static boolean reachEndpoint(int[][] map) {
        return dfs(0, 0, map, 9);
    }
    
    public static boolean dfs(int x, int y, int[][] map, int target) {
        if (map[x][y] == target) {
            return true;
        }
        
        for (int i = 0; i < 4; i++) {
            int xx = xd[i] + x;
            int yy = yd[i] + y;
            
            if (xx < 0 || xx >= map.length || yy < 0 || yy >= map[0].length) {
                continue;
            }
            
            if (map[xx][yy] == 0) {
                continue;
            }
            
            if (map[xx][yy] == 1) {
                map[xx][yy] = 0;
            }
            
            if (dfs(xx, yy, map, target)) {
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        
    }
    
}
