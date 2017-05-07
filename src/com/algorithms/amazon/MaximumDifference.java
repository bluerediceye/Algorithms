package com.algorithms.amazon;

/**
 * Created on 20/04/2017
 *
 * @author Ming Li
 */
public class MaximumDifference {

    int MAX_DIFF = Integer.MIN_VALUE;

    static class Node {
        Node left, right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    public int calculateMaxDiff(Node node){
        if(node == null){
            return Integer.MAX_VALUE;
        }

        if(node.left == null && node.right == null){
            return node.data;
        }

        int min = Math.min(calculateMaxDiff(node.left), calculateMaxDiff(node.right));

        MAX_DIFF = Math.max(MAX_DIFF, node.data - min);

        return Math.min(min, node.data);

    }

    public int getMaxDiff(){
        return MAX_DIFF;
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);

        root.right = new Node(10);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);

        MaximumDifference md = new MaximumDifference();
        md.calculateMaxDiff(root);
        System.out.println(md.getMaxDiff());
    }
}
