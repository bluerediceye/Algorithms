package com.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created on 15/03/2017
 *
 * @author Ming Li
 */
public class BinarySearchTree {

    int num = 0;
    Node root;

    public void insertNode(Node root, int value) {

        if (root == null) {
            return;
        }

        if (root.value > value) {
            if (root.left == null) {
                root.left = new Node(value);
                num++;
            } else {
                insertNode(root.left, value);
            }
        } else {
            if (root.right == null) {
                root.right = new Node(value);
                num++;
            } else {
                insertNode(root.right, value);
            }
        }
    }

    public void preOrder() {
        preOrderTraverse(root);
    }

    public void preOrder_advanced() {
        Stack<Node> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
            while (!stack.isEmpty()) {
                Node current = stack.pop();

                System.out.print(current.value + " ");
                if (current.right != null) {
                    stack.push(current.right);
                }

                if (current.left != null) {
                    stack.push(current.left);
                }
            }
        }
    }

    public void preOrder_advanced2() {
        Stack<Node> stack = new Stack<>();
        if (root != null) {
            Node current = root;
            while (!stack.isEmpty() || current != null) {
                while (current != null) {
                    System.out.print(current.value + " ");
                    stack.push(current);
                    current = current.left;
                }

                current = stack.pop();
                current = current.right;
            }
        }
    }

    private void preOrderTraverse(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrderTraverse(node.left);
            preOrderTraverse(node.right);
        }
    }

    public void midOrder() {
        midOrderTraverse(root);
    }

    public void midOrder_advanced2() {
        Stack<Node> stack = new Stack<>();
        if (root != null) {
            Node current = root;
            while (!stack.isEmpty() || current != null) {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }

                current = stack.pop();
                System.out.print(current.value + " ");
                current = current.right;
            }
        }
    }

    private void midOrderTraverse(Node node) {
        if (node != null) {
            midOrderTraverse(node.left);
            System.out.print(node.value + " ");
            midOrderTraverse(node.right);
        }
    }

    public void postOrder() {
        postOrderTraverse(root);
    }

    private void postOrderTraverse(Node node) {
        if (node != null) {
            postOrderTraverse(node.left);
            postOrderTraverse(node.right);
            System.out.print(node.value + " ");
        }
    }

    public void postOrder_advanced() {


        Stack<Node> stack = new Stack<>();
        int[] flag = new int[100];

        Node current = root;
        while (current != null) {

            stack.push(current);
            current = current.left;
            flag[stack.size()] = 0;
        }

        while (!stack.isEmpty()) {

            current = stack.peek();
            while (current != null && flag[stack.size()] == 0) {
                current = current.right;
                flag[stack.size()] = 1;
                while (current != null) {
                    stack.push(current);
                    flag[stack.size()] = 0;
                    current = current.left;
                }
                current = stack.peek();
            }
            current = stack.pop();
            System.out.print(current.value + " ");
        }
    }

    public boolean lookup(int value) {
        if (root == null) {
            System.out.printf("Not found!");
        }
        return lookUpTree(root, value);
    }

    private boolean lookUpTree(Node node, int value) {
        if (value < node.value) {
            if (node.left == null) {
                System.out.printf("Not found!");
                return false;
            } else {
                return lookUpTree(node.left, value);
            }
        } else if (value > node.value) {
            if (node.right == null) {
                System.out.printf("Not found!");
                return false;
            } else {
                return lookUpTree(node.right, value);
            }
        } else {
            System.out.println("Found: " + node.value);
            return true;
        }
    }

    public void level_tree() {

        Queue<Node> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);

            Node current = queue.poll();
            while (current != null) {
                System.out.print(current.value + " ");

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
                current = queue.poll();
            }
        }
    }

    public boolean isBalanced() {
        if (root == null) {
            return true;
        }

        int left = getTreeDepth(root.left);
        int right = getTreeDepth(root.right);

        return Math.abs(left - right) <= 1;

    }


    public int getTreeDepth() {
        return getTreeDepth(root);
    }

    public int getTreeDepth(Node node) {
        if (node == null) {
            return 0;
        }

        int left = getTreeDepth(node.left);
        int right = getTreeDepth(node.right);
        return left >= right ? left + 1 : right + 1;
    }



    public static boolean isEqual(Node a, Node b) {

        if (a == null && b == null) {
            return true;
        }

        return a != null && b != null && a.value == b.value && isEqual(a.left, b.left) && isEqual(a.right, b.right);
    }

    public Node findLCA_BST(int a, int b) {
        return findLCA_BST(root, a, b);
    }

    public Node findLCA_BST_Advanced(int a, int b) {

        Node current = root;
        while (current != null) {

            if (current.value > a && current.value > b) {
                current = current.left;
            } else if (current.value < a && current.value < b) {
                current = current.right;
            } else {
                break;
            }

        }
        return current;
    }

    private Node findLCA_BST(Node n, int a, int b) {
        if (n == null) {
            return null;
        }

        if (root.left.value > a && root.left.value > b) {
            return findLCA_BST(n.left, a, b);
        }

        if (root.right.value >   a && root.right.value > b) {
            return findLCA_BST(root.right, a, b);
        }

        return n;
    }

    public Node findLCA(int a, int b) {
        return findLCA(root, a, b);
    }

    private Node findLCA(Node n, int a, int b) {

        if (n == null) {
            return null;
        }

        if (n.value == a || n.value == b) {
            return n;
        }

        Node left = findLCA(n.left, a, b);
        Node right = findLCA(n.right, a, b);

        if (left != null && right != null) {
            return n;
        }

        return left != null ? left : right;
    }

    public  boolean isSubTree(Node a){
        if(a == null){
            return true;
        }


        Queue<Node> queue = new LinkedList<>();

        Node cur = root;
        queue.add(cur);
        while(!queue.isEmpty()){

            cur = queue.poll();
            if(isEquals(cur, a)){
                return true;
            }

            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }

        }

        return false;
    }


    public static boolean isEquals(Node a, Node b){

        if(a == null && b == null){
            return true;
        }

        return a!=null&&b!=null&& a.value == b.value && isEquals(a.left, b.left) && isEquals(a.right, b.right) ;
    }


    @Override
    public int hashCode() {
        int result = num;
        result = 31 * result + (root != null ? root.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        /**
         *              5
         *          4       6
         *      1               7
         *  0       2               9
         *              3       8       10
         *
         */

        int[] newValues = {4, 6, 1, 2, 7, 3, 9, 8, 10, 0};

        BinarySearchTree tree = new BinarySearchTree();
        tree.root = new Node(5);

        for (int value : newValues) {
            tree.insertNode(tree.root, value);
        }

        System.out.println("Pre Order Traverse:");
        tree.preOrder();
        System.out.println("\n");

        System.out.println("Advanced Pre Order Traverse:");
        tree.preOrder_advanced();
        System.out.println("\n");

        System.out.println("Advanced 2 Pre Order Traverse:");
        tree.preOrder_advanced2();
        System.out.println("\n");

        System.out.println("Mid Order Traverse:");
        tree.midOrder();
        System.out.println("\n");

        System.out.println("Mid 2 Order Traverse:");
        tree.midOrder_advanced2();
        System.out.println("\n");

        System.out.println("Post Order Traverse:");
        tree.postOrder();
        System.out.println("\n");

        System.out.println("Advanced Post Order Traverse:");
        tree.postOrder_advanced();
        System.out.println("\n");

        int s = 8;
        System.out.println("Lookup: " + s);
        tree.lookup(s);

        s = 99;
        System.out.println("Lookup: " + s);
        tree.lookup(s);

        System.out.println();

        System.out.println("com.algorithms.amazon9.sde1.Tree depth: " + tree.getTreeDepth());

        System.out.println("Balanced: " + tree.isBalanced());

        System.out.println("Level Traversing tree: ");
        tree.level_tree();


//        int[] otherValues = {4, 6, 1, 2, 7, 3, 9, 8, 10, 0};
        int[] otherValues = {8, 10};

        BinarySearchTree tree2 = new BinarySearchTree();
        tree2.root = new Node(9);

        for (int value : otherValues) {
            tree2.insertNode(tree2.root, value);
        }
        System.out.println("Is Equal: " + isEqual(tree.root, tree2.root));
        System.out.println("Is Subtree: " + tree.isSubTree(tree2.root));
        System.out.println("Common ancestor:  " + tree.findLCA(3, 8).value);
    }
}
