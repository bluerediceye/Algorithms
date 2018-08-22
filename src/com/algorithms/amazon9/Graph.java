package com.algorithms.amazon9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created on 02/04/2017
 *
 * @author Ming Li
 */
public class Graph {
    public Node rootNode;
    public ArrayList<Node> nodes = new ArrayList<>();
    public int[][] adjMatrix;//Edges will be represented as adjacency Matrix
    int size;
    
    public static void main(String[] args) {
        
        //Lets create nodes as given as an example in the article
        Node nA = new Node('A');
        Node nB = new Node('B');
        Node nC = new Node('C');
        Node nD = new Node('D');
        Node nE = new Node('E');
        Node nF = new Node('F');
        
        //Create the graph, add nodes, create edges between nodes
        Graph g = new Graph();
        g.addNode(nA);
        g.addNode(nB);
        g.addNode(nC);
        g.addNode(nD);
        g.addNode(nE);
        g.addNode(nF);
        g.setRootNode(nA);
        
        g.connectNode(nA, nB);
        g.connectNode(nA, nC);
        g.connectNode(nA, nD);
        
        g.connectNode(nB, nE);
        g.connectNode(nB, nF);
        g.connectNode(nC, nF);
        
        
        //Perform the traversal of the graph
        System.out.println("\nDFS Traversal of a tree is ------------->");
        g.dfs();
        
        System.out.println("\nDFS Traversal Recursively of a tree is ------------->");
        g.dfs_recursive();
        
        System.out.println("\nBFS Traversal of a tree is ------------->");
        g.bfs();
    }
    
    public Node getRootNode() {
        return this.rootNode;
    }
    
    public void setRootNode(Node n) {
        this.rootNode = n;
    }
    
    public void addNode(Node n) {
        nodes.add(n);
    }
    
    //This method will be called to make connect two nodes
    public void connectNode(Node start, Node end) {
        if (adjMatrix == null) {
            size = nodes.size();
            adjMatrix = new int[size][size];
        }
        
        int startIndex = nodes.indexOf(start);
        int endIndex = nodes.indexOf(end);
        adjMatrix[startIndex][endIndex] = 1;
        adjMatrix[endIndex][startIndex] = 1;
    }
    
    private Node getUnvisitedChildNode(Node n) {
        
        int index = nodes.indexOf(n);
        for (int j = 0; j < size; j++) {
            if (adjMatrix[index][j] == 1 && !(nodes.get(j)).visited) {
                return nodes.get(j);
            }
        }
        return null;
    }
    
    private List<Node> getUnvisitedChildrenNodes(Node n) {
        List<Node> children = new ArrayList<>();
        int index = nodes.indexOf(n);
        for (int j = 0; j < size; j++) {
            if (adjMatrix[index][j] == 1 && !(nodes.get(j)).visited) {
                children.add(nodes.get(j));
            }
        }
        return children;
    }
    
    //BFS traversal of a tree is performed by the bfs() function
    public void bfs() {
        
        //BFS uses Queue data structure
        Queue<Node> q = new LinkedList<>();
        q.add(this.rootNode);
        printNode(this.rootNode);
        rootNode.visited = true;
        while (!q.isEmpty()) {
            Node n = q.poll();
            Node child;
            while ((child = getUnvisitedChildNode(n)) != null) {
                child.visited = true;
                printNode(child);
                q.offer(child);
            }
        }
        //Clear visited property of nodes
        clearNodes();
    }
    
    //DFS traversal of a tree is performed by the dfs() function
    public void dfs() {
        //DFS uses Stack data structure
        Stack<Node> s = new Stack<>();
        s.push(this.rootNode);
        rootNode.visited = true;
        printNode(rootNode);
        while (!s.isEmpty()) {
            Node n = s.peek();
            Node child = getUnvisitedChildNode(n);
            if (child != null) {
                child.visited = true;
                printNode(child);
                s.push(child);
            } else {
                s.pop();
            }
        }
        //Clear visited property of nodes
        clearNodes();
    }
    
    private void dfs_recursive(Node node) {
        
        if (node != null) {
            node.visited = true;
            System.out.print(node.label + " ");
            
            List<Node> children = getUnvisitedChildrenNodes(node);
            
            for (Node child : children) {
                if (!child.visited) {
                    dfs_recursive(child);
                }
            }
        }
    }
    
    public void dfs_recursive() {
        dfs_recursive(this.rootNode);
        clearNodes();
    }
    
    public boolean isCircle(Node node) {
        return false;
    }
    
    //Utility methods for clearing visited property of node
    private void clearNodes() {
        int i = 0;
        while (i < size) {
            Node n = nodes.get(i);
            n.visited = false;
            i++;
        }
    }
    
    //Utility methods for printing the node's label
    private void printNode(Node n) {
        System.out.print(n.label + " ");
    }
    
    public static class Node {
        public char label;
        public boolean visited = false;
        
        public Node(char l) {
            this.label = l;
        }
    }
}



