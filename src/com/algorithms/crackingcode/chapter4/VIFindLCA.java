package com.algorithms.crackingcode.chapter4;

/**
 * Created on 28/03/2017
 *
 * @author Ming Li
 */
public class VIFindLCA {
    
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
        
        System.out.println("First common ancestor of e and h is: " + new VIFindLCA().findLCA(root, e, h).value);
        System.out.println("First common ancestor of e and h is: " + new VIFindLCA().findLCA2(root, e, h).value);
        
        System.out.println("First common ancestor of c and h is: " + new VIFindLCA().findLCA(root, c, h).value);
        System.out.println("First common ancestor of c and h is: " + new VIFindLCA().findLCA2(root, c, h).value);
    }
    
    public Node findLCA(Node root, Node a, Node b) {
        
        if (root == null) {
            return null;
        }
        
        if (root == a || root == b) {
            return root;
        }
        
        Node left = findLCA(root.left, a, b);
        Node right = findLCA(root.right, a, b);
        
        if (left != null && right != null) {
            return root;
        }
        
        return left != null ? left : right;
    }
    
    public Node findLCA2(Node root, Node a, Node b) {
        
        if (cover(root.left, a) && cover(root.left, b)) {
            return findLCA2(root.left, a, b);
        }
        
        if (cover(root.right, a) && cover(root.right, b)) {
            return findLCA2(root.right, a, b);
        }
        
        return root;
    }
    
    public boolean cover(Node a, Node b) {
        if (a == null) {
            return false;
        }
        if (a == b) {
            return true;
        }
        
        return cover(a.left, b) || cover(a.right, b);
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
