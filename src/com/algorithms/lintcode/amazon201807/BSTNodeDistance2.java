package com.algorithms.lintcode.amazon201807;

/**
 * Created on 13/08/2018
 *
 * @author Ming Li
 */
public class BSTNodeDistance2 {
    public int bstDistance(int[] numbers, int node1, int node2) {
        if (numbers == null || numbers.length < 2) {
            return -1;
        }
        if (!check(numbers, node1, node2)) {
            return -1;
        }
        TreeNode root = buildTree(numbers);
        return findDist(root, node1, node2);
    }
    
    private boolean check(int[] numbers, int node1, int node2) {
        boolean hasNode1 = false, hasNode2 = false;
        for (int num : numbers) {
            if (num == node1) {
                hasNode1 = true;
            } else if (num == node2) {
                hasNode2 = true;
            }
        }
        return hasNode1 && hasNode2;
    }
    
    private TreeNode buildTree(int[] numbers) {
        TreeNode root = new TreeNode(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            insert(root, numbers[i]);
        }
        return root;
    }
    
    private TreeNode insert(TreeNode root, int num) {
        if (root == null) {
            return new TreeNode(num);
        }
        if (root.val > num) {
            root.left = insert(root.left, num);
        } else {
            root.right = insert(root.right, num);
        }
        return root;
    }
    
    private int findDistFromRoot(TreeNode root, int node) {
        if (root.val == node) {
            return 0;
        } else if (root.val > node) {
            return 1 + findDistFromRoot(root.left, node);
        } else {
            return 1 + findDistFromRoot(root.right, node);
        }
    }
    
    private int findDist(TreeNode root, int node1, int node2) {
        if (root.val > node1 && root.val > node2) {
            return findDist(root.left, node1, node2);
        } else if (root.val < node1 && root.val < node2) {
            return findDist(root.right, node1, node2);
        } else {
            return findDistFromRoot(root, node1) + findDistFromRoot(root, node2);
        }
    }
    
    class TreeNode {
        public int val;
        public TreeNode left, right;
        
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
}
