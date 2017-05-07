package com.algorithms.amazon9.sde1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created on 01/03/2017
 *
 * @author Ming Li
 */
public class BSTMinimumSum {

    public static void main(String[] args) {
        TreeNode one = new TreeNode(20);
        TreeNode two = new TreeNode(19);
        TreeNode three = new TreeNode(18);
        TreeNode four = new TreeNode(17);
        TreeNode five = new TreeNode(23);

        one.left = two;
        one.right = three;

        two.left = new TreeNode(7);
        two.right = new TreeNode(28);

        three.left = four;
        three.right = five;

        System.out.println(DFS(one));

    }




   //recursively
    public static int DFS(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left != null && root.right != null) {
            return root.value+Math.min(DFS(root.left), DFS(root.right));
        } else {
            return root.value+Math.max(DFS(root.left), DFS(root.right));
        }
    }

    // iteratively, BFS
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int l = queue.size();
            for (int i = 0; i < l; i++) {
                TreeNode n = queue.poll();
                if (n.left == null && n.right == null) {
                    return depth;
                }
                if (n.left != null) {
                    queue.add(n.left);
                }
                if (n.right != null) {
                    queue.add(n.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static class TreeNode {
        protected int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value){
            this.value = value;
        }

    }
}
