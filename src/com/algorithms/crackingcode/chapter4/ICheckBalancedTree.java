package com.algorithms.crackingcode.chapter4;

/**
 * Created on 29/03/2017
 *
 * @author Ming Li
 */
public class ICheckBalancedTree {


    static class Node {
        int value;
        Node left;
        Node right;
        Node parent;

        public Node(int x) {
            this.value = x;
        }
    }

    public boolean isBalanced(Node root){
        if(root == null){
            return true;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public boolean isBalanced2(Node root) {
        return root == null || Math.abs(maxDepth(root) - minDepth(root)) <= 1;

    }

    public int maxDepth(Node root){

        if(root == null){
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int minDepth(Node root){
        if(root == null){
            return 0;
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    /**
     *             9
     *            / \
     *          3    4
     *         / \  / \
     *        2  1 5  6
     *               / \
     *              9   0
     *
     *            8
     *           / \
     *          5   7
     *         /     \
     *        1       2
     */
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


        Node aa = new Node(8);
        Node bb = new Node(8);
        Node cc = new Node(8);
        Node dd = new Node(8);
        Node ee = new Node(8);

        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        f.left = g;
        f.right = h;

        aa.left = bb;
        aa.right = cc;
        bb.left = dd;
        cc.right = ee;

        System.out.println("com.algorithms.amazon9.sde1.Tree is balanced: " + new ICheckBalancedTree().isBalanced(root));
        System.out.println("com.algorithms.amazon9.sde1.Tree is balanced: " + new ICheckBalancedTree().isBalanced2(root));

        h.right = new Node(90);

        System.out.println("com.algorithms.amazon9.sde1.Tree is balanced: " + new ICheckBalancedTree().isBalanced(root));
        System.out.println("com.algorithms.amazon9.sde1.Tree is balanced: " + new ICheckBalancedTree().isBalanced2(root));
    }

}
