package com.algorithms.amazon;

/**
 * Created on 20/04/2017
 *
 * @author Ming Li
 */
public class FindNodeDistance {

    static class Node {
        Node left, right;
        int id;

        public Node(int id) {
            this.id = id;
        }
    }

    public Node findLCA(Node root, Node a, Node b){

        if(root == null){
            return null;
        }

        if(root == a || root == b){
            return root;
        }

        Node left = findLCA(root.left, a, b);
        Node right = findLCA(root.right, a, b);

        if(left != null && right != null){
            return root;
        }

        return left!=null?left:right;
    }

    public int getDepth(Node root, Node a){
        if(root == null){
            return -1;
        }

        if(root == a){
            return 0;
        }

        int left = getDepth(root.left, a);
        int right =getDepth(root.right, a);


        if(left == -1 && right==-1){
            return -1;
        }

        return left != -1 ? left + 1: right + 1;
    }

    public int distance(Node root, Node a, Node b){
        Node ancestor = findLCA(root, a, b);
        return getDepth(root, a) + getDepth(root, b) - 2*getDepth(root, ancestor);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        System.out.println(new FindNodeDistance().distance(root,root.left.left, root.left.right ));
    }
}
