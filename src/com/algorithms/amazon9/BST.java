package com.algorithms.amazon9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created on 27/03/2017
 *
 * @author Ming Li
 */
public class BST {
    
    /* Returns true if given search tree is binary
       search tree (efficient version) */
    static Node prev;
    
    /**
     * 9
     * /   \
     * 3     4
     * / \   / \
     * 2   1 5  6
     * / \
     * 10  0
     * <p>
     * 8
     * / \
     * 5   7
     * /     \
     * 1       2
     */
    public static void main(String[] args) {
        
        
        byte[] x = new byte[]{1, 92};
        System.out.println(x[0] + " " + x[1]);
        
        Node root = new Node(9);
        Node a = new Node(3);
        Node b = new Node(14);
        Node c = new Node(2);
        Node d = new Node(5);
        Node e = new Node(11);
        Node f = new Node(16);
        Node g = new Node(15);
        Node h = new Node(17);
        
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        f.left = g;
        f.right = h;

//        new BST().nonRecursivePostOrder(root);
//        System.out.println(new BST().getDepth(root, h));
//        System.out.println(new BST().getDepth2(root, h));;
//        new BST().levelTraverse2(root);
        System.out.println(new BST().searchBST(root, 15).key);
        System.out.println(new BST().searchBST2(root, 15).key);
    }
    
    public int maxDepth(Node node) {
        if (node == null) {
            return 0;
        }
        
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }
    
    public int minDepth(Node node) {
        if (node == null) {
            return 0;
        }
    
        if (node.left == null && node.right == null) {
            return 1;
        }
        if (node.left == null) {
            return 1 + minDepth(node.right);
        }
        if (node.right == null) {
            return 1 + minDepth(node.left);
        }
        
        return Math.min(minDepth(node.left), minDepth(node.right)) + 1;
    }
    
    public boolean isBalanced(Node node) {
        return node == null || (maxDepth(node) - minDepth(node)) <= 1;
    }
    
    public boolean isEquals(Node a, Node b) {
        return (a == null && b == null) ||
                       (a != null && b != null && a.key == b.key && isEquals(a.left, b.left)
                                && isEquals(a.right, b.right));
    }
    
    public boolean isSubTree(Node a, Node b) {
        if (a == null) {
            return false;
        }
        
        if (b == null) {
            return true;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(a);
        Node current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (isEquals(current, b)) {
                return true;
            }
            
            if (current.left != null) {
                queue.offer(current.left);
            }
            
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        
        return false;
        
    }
    
    public boolean isSubTree2(Node a, Node b) {
        if (a == null) {
            return false;
        }
        
        if (b == null) {
            return true;
        }
        
        if (a.key == b.key) {
            if (isEquals(a, b)) {
                return true;
            }
        }
        
        return isSubTree2(a.left, b) || isSubTree2(a.right, b);
    }
    
    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }
    
    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.key + " ");
        }
    }
    
    public void nonRecursivePreOrder(Node node) {
        if (node != null) {
            Stack<Node> stack = new Stack<>();
            
            Node current = node;
            
            while (!stack.isEmpty() || current != null) {
                
                while (current != null) {
                    
                    System.out.print(current.key + "");
                    stack.push(current);
                    current = current.left;
                }
                
                current = stack.pop();
                current = current.right;
            }
        }
    }
    
    public Node nonRecursiveSearch(Node node, int x) {
        if (node == null) {
            return null;
        }
        
        Node current = node;
        
        while (current != null) {
            
            if (x < current.key) {
                current = current.left;
            } else if (x > current.key) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }
    
    public void nonRecursiveInOrder(Node node) {
        if (node != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(node);
            Node current = node;
            while (!stack.isEmpty() || current != null) {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                
                current = stack.pop();
                System.out.printf(current.key + " ");
                current = current.right;
            }
        }
    }
    
    public void nonRecursivePostOrder(Node node) {
        
        if (node != null) {
            
            Stack<Node> stack = new Stack<>();
            Node current = node;
            stack.push(current);
            while (!stack.isEmpty()) {
                current = stack.peek();
                
                if (current.left != null && !current.left.visited) {
                    stack.push(current.left);
                } else if (current.right != null && !current.right.visited) {
                    stack.push(current.right);
                } else {
                    System.out.print(current.key + " ");
                    current.visited = true;
                    stack.pop();
                }
                
            }
        }
    }
    
    public void levelTraverse(Node node) {
        if (node != null) {
            
            Queue<Node> queue = new LinkedList<>();
            
            Node current = node;
            queue.offer(current);
            while (!queue.isEmpty()) {
                
                current = queue.poll();
                System.out.printf(current.key + " ");
                if (current.left != null) {
                    queue.offer(current.left);
                }
                
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
    }
    
    public void levelTraverse2(Node node) {
        if (node != null) {
            List<Node> nodes = new ArrayList<>();
            nodes.add(node);
            boolean leftToRight = true;
            while (!nodes.isEmpty()) {
                
                if (leftToRight) {
                    for (int i = 0; i < nodes.size(); i++) {
                        System.out.print(nodes.get(i).key + "->");
                    }
                } else {
                    for (int i = nodes.size() - 1; i >= 0; i--) {
                        System.out.print(nodes.get(i).key + "->");
                    }
                }
                
                System.out.println();
                
                leftToRight = !leftToRight;
                
                List<Node> tmpNodes = new ArrayList<>();
                
                for (int i = 0; i < nodes.size(); i++) {
                    Node current = nodes.get(i);
                    if (current.left != null) {
                        tmpNodes.add(current.left);
                    }
                    if (current.right != null) {
                        tmpNodes.add(current.right);
                    }
                }
                
                nodes = tmpNodes;
            }
        }
    }
    
    public Node searchBST(Node node, int x) {
        if (node == null) {
            return null;
        }
        
        if (x > node.key) {
            return searchBST(node.right, x);
        } else if (x < node.key) {
            return searchBST(node.left, x);
        } else {
            return node;
        }
    }
    
    public Node searchBST2(Node node, int x) {
        if (node == null) {
            return null;
        }
        
        while (node != null) {
            if (node.key > x) {
                node = node.left;
            } else if (node.key < x) {
                node = node.right;
            } else {
                return node;
            }
        }
        
        return null;
    }
    
    boolean isBST(Node node) {
        // traverse the tree in inorder fashion and
        // keep a track of previous node
        if (node != null) {
            if (!isBST(node.left)) {
                return false;
            }

//             allows only distinct values node
            if (prev != null && node.key <= prev.key) {
                return false;
            }
            prev = node;
            return isBST(node.right);
        }
        return true;
    }
    
    public boolean isBST(Node p, double min, double max) {
        if (p == null) {
            return true;
        }
    
        if (p.key <= min || p.key >= max) {
            return false;
        }
        
        return isBST(p.left, min, p.key) && isBST(p.right, p.key, max);
    }
    
    public void insert(Node node, int x) {
        if (node != null) {
            
            if (node.key > x) {
                if (node.left == null) {
                    node.left = new Node(x);
                } else {
                    insert(node.left, x);
                }
            }
            if (node.key < x) {
                if (node.right == null) {
                    node.right = new Node(x);
                } else {
                    insert(node.right, x);
                }
            }
        }
    }
    
    public void nonRecursiveInsert(Node node, int x) {
        if (node != null) {
            
            Node current = node;
            while (current != null) {
                
                if (current.key > x) {
                    if (current.left == null) {
                        current.left = new Node(x);
                    } else {
                        current = current.left;
                    }
                }
                
                if (current.key < x) {
                    if (current.right == null) {
                        current.right = new Node(x);
                    } else {
                        current = current.right;
                    }
                }
            }
        }
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
        if (root == null) {
            return null;
        }
        
        
        if (root.key > a.key && root.key > b.key) {
            return findLCA2(root.left, a, b);
        }
        
        if (root.key < a.key && root.key < b.key) {
            return findLCA2(root.right, a, b);
        }
        
        return root;
    }
    
    public Node findLCA3(Node root, Node a, Node b) {
        if (root == null) {
            return null;
        }
        
        Node current = root;
        
        while (current != null) {
            
            if (current.key > a.key && current.key > b.key) {
                current = current.left;
            } else if (current.key < a.key && current.key < b.key) {
                current = current.right;
            } else {
                return current;
            }
            
        }
        
        return null;
    }
    
    public int getDepth(Node root, Node a) {
        if (root == null) {
            return -1;
        }
        
        if (root == a) {
            return 0;
        }
        
        int left = getDepth(root.left, a);
        int right = getDepth(root.right, a);
        
        if (left == -1 && right == -1) {
            return -1;
        }
        
        return left != -1 ? left + 1 : right + 1;
    }
    
    public int getDepth2(Node root, Node a) {
        if (root == null) {
            return -1;
        }
    
        if (root == a) {
            return 0;
        }
        
        List<Node> q = new ArrayList<>();
        q.add(root);
        
        int depth = 0;
        while (!q.isEmpty()) {
            
            List<Node> tmp = new ArrayList<>();
            for (Node n : q) {
                if (n.left != null) {
                    tmp.add(n.left);
                }
                if (n.right != null) {
                    tmp.add(n.right);
                }
            }
            
            q = tmp;
            if (!tmp.isEmpty()) {
                depth++;
            }
        }
        
        return depth;
    }
    
    public int getDistance(Node root, Node a, Node b) {
        Node ancestor = findLCA(root, a, b);
        
        int left = getDepth(root, a);
        int right = getDepth(root, b);
        int anc = getDepth(root, ancestor);
        
        return Math.abs(left + right - 2 * anc);
    }
    
    static class Node {
        int key;
        Node left;
        Node right;
        Node parent;
        boolean visited;
        
        public Node(int x) {
            this.key = x;
        }
    }
}
