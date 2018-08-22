package com.algorithms.crackingcode.chapter4;

/**
 * Created on 28/03/2017
 *
 * @author Ming Li
 */
public class VIICheckIfSubTree {
    
    /**
     * 9
     * / \
     * 3    4
     * / \  / \
     * 2  1 5  6
     * / \
     * 9   0
     * <p>
     * 8
     * / \
     * 5   7
     * /     \
     * 1       2
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
        
        System.out.println("Is b subtree of root: " + new VIICheckIfSubTree().isSubTree(root, b));
        System.out.println("Is e subtree of root: " + new VIICheckIfSubTree().isSubTree(root, e));
        System.out.println("Is aa subtree of root: " + new VIICheckIfSubTree().isSubTree(root, aa));
    }
    
    public boolean isSubTree(Node big, Node small) {
        if (big == null) {
            return false;
        }
        
        if (small == null) {
            return true;
        }
        
        if (big.value == small.value) {
            if (isEquals(big, small)) {
                return true;
            }
        }
        
        return isSubTree(big.left, small) || isSubTree(big.right, small);
    }
    
    public boolean isEquals(Node a, Node b) {
        return a == b && a == null || (a != null && b != null && isEquals(a.left, b.left) && isEquals(a.right, b.right));
    }
    
    public static class Node {
        Node left;
        Node right;
        int value;
        
        public Node(int value) {
            this.value = value;
        }
    }
}
