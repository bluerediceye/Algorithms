package com.algorithms.crackingcode.chapter4;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created on 29/03/2017
 *
 * @author Ming Li
 */
public class IICheckIfTwoNodesConnected {

    static class Node {
        int value;
        Node[] nodes = {};
        State state = State.UNVISITED;

        public Node(int x) {
            this.value = x;
        }
    }

    static enum State {
        VISITING, VISITED, UNVISITED
    }


    boolean isConnected(Node a, Node b){

        Queue<Node> queue = new LinkedList<>();

        queue.offer(a);

        while(!queue.isEmpty()){
            Node current = queue.poll();
            current.state = State.VISITED;

            if(current == b){
                return true;
            }

            for(Node n : current.nodes){
                if(n.state == State.UNVISITED){
                    queue.offer(n);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(9);
        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(2);
        Node d = new Node(1);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(9);
        Node h = new Node(0);

        root.nodes = new Node[]{a, b, e};
        e.nodes = new Node[]{a, b, f,g};
        f.nodes = new Node[]{a, b, g};
        h.nodes = new Node[]{c, d, g};

        System.out.println("a is connected to g:" + new IICheckIfTwoNodesConnected().isConnected(a, g));

        a.nodes = new Node[]{f};
        f.nodes = new Node[]{h};
        System.out.println("a is connected to g:" + new IICheckIfTwoNodesConnected().isConnected(a, g));
    }
}
