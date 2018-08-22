package com.algorithms.amazon;

import java.util.LinkedList;

/**
 * Created on 20/04/2017
 *
 * @author Ming Li
 */
public class DetectCircle {
    
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
    
        if (new DetectCircle().isCyclic(g)) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't contain cycle");
        }
    }
    
    public boolean isCyclic(Graph g) {
        
        int[] mark = new int[g.num];
        
        for (int i = 0; i < g.adj.length; i++) {
            
            if (mark[i] == 0 && dfs(g, i, mark)) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean dfs(Graph g, int v, int[] mark) {
        
        mark[v] = 1;
        
        
        for (int j = 0; j < g.adj[v].size(); j++) {
            if (mark[(int) g.adj[v].get(j)] == 1) {
                return true;
            }
            
            if (mark[(int) g.adj[v].get(j)] == 0 && dfs(g, (int) g.adj[v].get(j), mark)) {
                return true;
            }
        }
        
        mark[v] = 2;
        return false;
        
    }
    
    @SuppressWarnings("unchecked")
    static class Graph {
        
        int num;
        LinkedList[] adj;
        
        public Graph(int num) {
            this.num = num;
            adj = new LinkedList[4];
            for (int i = 0; i < num; i++) {
                adj[i] = new LinkedList();
            }
        }
        
        public void addEdge(int i, int j) {
            adj[i].add(j);
        }
    }
}
