package com.algorithms.crackingcode.chapter4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 28/03/2017
 *
 * @author Ming Li
 */
public class VIIIBinaryTreePathSum {

    static class Node {
        int key;
        Node left;
        Node right;
        Node parent;

        public Node(int x) {
            this.key = x;
        }
    }

    void findSum(Node root, ArrayList<Node> buffer, int sum, int level){

        if(root != null){

            int tmp = sum;
            buffer.add(root);

            for(int i = level;i>=0;i--){
                tmp -= buffer.get(i).key;
                if(tmp == 0){
                    print(buffer, i, level);
                }
            }

            ArrayList<Node> leftBuffer = (ArrayList<Node>) buffer.clone();
            ArrayList<Node> rightBuffer = (ArrayList<Node>) buffer.clone();
            findSum(root.left, leftBuffer, sum, level + 1);
            findSum(root.right, rightBuffer, sum, level + 1);
        }
    }


    /**
     *                  1
     *                /   \
     *              2     3
     *             / \
     *           3    4
     *          / \
     *       -1    3
     *       / \
     *     1    2
     *    /
     *  0
     *
     * @param args
     */
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node bb = new Node(3);
        Node c = new Node(4);
        Node d = new Node(-1);
        Node e = new Node(3);
        Node f = new Node(1);
        Node g = new Node(2);
        Node h = new Node(0);

        root.left = a;
        root.right = b;
        a.left = bb;
        a.right = c;
        bb.left = d;
        bb.right = e;
        d.left = f;
        d.right = g;
        f.left = h;

        new VIIIBinaryTreePathSum().findSum(root, new ArrayList<>(), 6, 0);



    }


    public void print(List<Node> buffer, int start, int end){

        for(int i = start; i<=end;i++){

            System.out.print(buffer.get(i).key + (i+1<=end? "->" : ""));
        }
        System.out.println();
    }
}
