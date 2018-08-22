package com.algorithms.crackingcode.chapter4;

/**
 * Created on 28/03/2017
 *
 * @author Ming Li
 */
public class VFindSuccessorOfInOrder {
    
    public Node findSuccessor(Node x) {
        
        if (x == null) {
            return null;
        }
        
        if (x.right != null || x.parent == null) {
            
            Node current = x.right;
            Node tmp = current;
            while (current != null) {
                current = current.left;
            }
            
            return tmp;
        } else {
            
            Node parent = x.parent;
            if (parent.right == null) {
                return x.left;
            } else {
                
            }
            
            
        }
        
        return null;
        
        
    }
    
    public static class Node {
        Node parent;
        Node left;
        Node right;
        int value;
        
        public Node(int value) {
            this.value = value;
        }
    }
}
