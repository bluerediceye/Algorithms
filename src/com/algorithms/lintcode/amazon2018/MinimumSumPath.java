package com.algorithms.lintcode.amazon2018;

import com.algorithms.amazon9.sde1.Tree;

/**
 * Created on 08/08/2018
 *
 * @author Ming Li
 */
public class MinimumSumPath {
    
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    
    
    /**
     * @param root: the root
     * @return: minimum sum
     */
    public int minimumSum(TreeNode root) {
        // Write your code here
        if(root == null){
            return -1;
        }
        
        return findMinimumSum(root);
    }
    
    public int findMinimumSum(TreeNode root){
        
        if(root.left != null && root.right != null){
            int left = findMinimumSum(root.left) + root.val;
            int right = findMinimumSum(root.right) + root.val;
            return Math.min(left, right);
        }
        
        if(root.left != null){
            return findMinimumSum(root.left) + root.val;
        }
    
        if(root.right != null){
            return findMinimumSum(root.right) + root.val;
        }
        
        return root.val;
    }
}
