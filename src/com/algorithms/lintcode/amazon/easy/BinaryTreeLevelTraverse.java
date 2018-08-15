package com.algorithms.lintcode.amazon.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created on 15/08/2018
 *
 * @author Ming Li
 */
public class BinaryTreeLevelTraverse {
    public static class TreeNode {
        public int val;
        public TreeNode left, right;
        
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        List<List<Integer>> results = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            results.add(level);
        }
        
        return results;
    }
}
