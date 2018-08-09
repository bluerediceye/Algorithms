package com.algorithms.lintcode.amazon9problems;

import com.algorithms.amazon9.sde1.Tree;

/**
 * Created on 09/08/2018
 *
 * @author Ming Li
 */
public class MaximumSubtree {
    
    private TreeNode maxNode;
    private int max = Integer.MIN_VALUE;
    
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        findSum(root);
        
        return this.maxNode;
    }
    
    public int findSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int right = findSum(root.right);
        int left = findSum(root.left);
        
        int val = left + right + root.val;
        
        if(val > this.max){
            this.max = val;
            this.maxNode = root;
        } 
        
        return val;
    }
    
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
}
