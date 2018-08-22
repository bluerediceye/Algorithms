package com.algorithms.crackingcode.chapter4;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created on 29/03/2017
 *
 * @author Ming Li
 */
public class IIICreateBSTFromArray {
    
    
    public static void main(String[] args) {
//        int[] values = {1, 2, 3,4};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        Node node = new IIICreateBSTFromArray().insertNode(values, 0, values.length - 1);
        new IIICreateBSTFromArray().levelTraverse(node);
        
        System.out.println("Is tree balanced: " + new IIICreateBSTFromArray().isBalanced(node));
        System.out.println("Is tree balanced: " + new IIICreateBSTFromArray().maxDepth(node));
        System.out.println("Is tree balanced: " + new IIICreateBSTFromArray().minDepth(node));
    }
    
    public Node insertNode(int[] buffer, int start, int end) {
        if (start > end) {
            return null;
        }
        
        if (start == end) {
            return new Node(buffer[start]);
        }
        
        int mid = (start + end) / 2;
        
        Node root = new Node(buffer[mid]);
        Node left = insertNode(buffer, start, mid - 1);
        Node right = insertNode(buffer, mid + 1, end);
        
        root.left = left;
        root.right = right;
        return root;
    }
    
    public boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    public boolean isBalanced2(Node root) {
        return root == null || Math.abs(maxDepth(root) - minDepth(root)) <= 1;
        
    }
    
    public int minDepth(Node root) {
        if (root == null) {
            return 0;
        }
        
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
    
    public int maxDepth(Node root) {
        
        if (root == null) {
            return 0;
        }
        
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
    
    public void levelTraverse(Node a) {
        if (a != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(a);
            while (!queue.isEmpty()) {
                
                Node current = queue.poll();
                
                if (current.left != null) {
                    queue.add(current.left);
                }
                
                if (current.right != null) {
                    queue.add(current.right);
                }
                
                System.out.println(current.value);
            }
            
        }
    }
    
    static class Node {
        int value;
        Node left;
        Node right;
        Node parent;
        
        public Node(int x) {
            this.value = x;
        }
    }
    
    
}
