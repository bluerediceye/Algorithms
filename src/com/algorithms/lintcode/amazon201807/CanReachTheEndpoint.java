package com.algorithms.lintcode.amazon201807;

/**
 * Created on 12/08/2018
 *
 * @author Ming Li
 */
public class CanReachTheEndpoint {
    
    private int[] xx = new int[]{0,0,-1,1};
    private int[] yy = new int[]{1,-1,0,0};
    public boolean reachEndpoint(int[][] map) {
        // Write your code here
        return dfs(0,0, map, 9);
    }
    
    boolean dfs(int x, int y, int[][] map, int target){
        if(map[x][y] == target){
            return true;
        }
        
        for(int i=0;i<4;i++){
            int nx = xx[i] + x;
            int ny = yy[i] + y;
            
            if(nx >= map[0].length || ny >=map.length || nx < 0 || ny < 0){
                continue;
            }
            
            if(map[nx][ny] == 0) {
                continue;
            }
            
            if(map[nx][ny] == 1) {
                map[nx][ny] = 0;
            }
            
            if(dfs(nx, ny, map, target)){
                return true;
            }
        }
        
        return false;
    }
    
}
