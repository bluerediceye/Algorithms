package com.algorithms.lintcode.amazon201807;

/**
 * Created on 13/08/2018
 *
 * @author Ming Li
 */
public class BSTNodeDistance {
    private void insert(TreeNode root, int num) {
        if (root.val < num) {
            if (root.right == null) {
                root.right = new TreeNode(num);
            } else {
                insert(root.right, num);
            }
        } else {
            if (root.left == null) {
                root.left = new TreeNode(num);
            } else {
                insert(root.left, num);
            }
        }
    }
    
    private int findDis(TreeNode node, int target) {
        if (node.val == target) {
            return 0;
        }
        if (node.val < target) {
            return findDis(node.right, target) + 1;
        } else {
            return findDis(node.left, target) + 1;
        }
    }
    
    public int bstDistance(int[] numbers, int node1, int node2) {
        boolean exist1 = false, exist2 = false;
        
        TreeNode root = new TreeNode(numbers[0]);
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == node1) {
                exist1 = true;
            }
            if (numbers[i] == node2) {
                exist2 = true;
            }
            if (i == 0) {
                continue;
            }
            insert(root, numbers[i]);
        }
        
        if (!exist1 || !exist2) {
            return -1;
        }
        
        while (root.val > node1 && root.val > node2 || root.val < node1 && root.val < node2) {
            if (root.val > node1) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        
        return findDis(root, node1) + findDis(root, node2);
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
