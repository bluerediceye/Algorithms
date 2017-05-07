package com.algorithms.amazon9.sde1;

import java.util.Arrays;

/**
 * Created on 03/03/2017
 *
 * @author Ming Li
 */
public class Tree {
    public static class TreeNode {
        public TreeNode left, right;
        public int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int bstDistance(int[] values, int node1, int node2) {
        TreeNode root = buildTree(values);

        if (root == null) {
            return 0;
        }


        TreeNode one = new TreeNode(node1);
        TreeNode two = new TreeNode(node2);

        TreeNode ans = LCA(root, one, two);
        int depth1 = getDepth(root, ans);
        int depth2 = getDepth(root, one);
        int depth3 = getDepth(root, two);

        return Math.abs(depth2 + depth3 - 2 * depth1) ;

    }

    public static TreeNode LCA(TreeNode curr, TreeNode node1, TreeNode node2) {
        if (curr == null) {
            return null;
        }
        if (curr.val == node1.val || curr.val == node2.val) {
            return curr;
        }
        TreeNode left = LCA(curr.left, node1, node2);
        TreeNode right = LCA(curr.right, node1, node2);
        if (left != null) {
            return left;
        }else if(right != null){
            return right;
        }
        return null;
    }

    public static int getDepth(TreeNode curr, TreeNode target) {
        if (curr == null) {
            return -1;
        }
        if (curr.val == target.val) {
            return 0;
        }

        int left = getDepth(curr.left, target);
        int right = getDepth(curr.right, target);
        if (left == -1 && right == -1) return -1;
        return left != -1 ? left + 1 : right + 1;
    }

    public static TreeNode root;

    public static TreeNode buildTree(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        for (int value : values) {
            insertNode(root, value);
        }

        return root;
    }

    public static void insertNode(TreeNode node, int data) {
        if (root == null) {
            root = new TreeNode(data);
        } else {
            if (data < node.val) {
                if (node.left == null) {
                    node.left = new TreeNode(data);
                } else {
                    insertNode(node.left, data);
                }
            } else {
                if (node.right == null) {
                    node.right = new TreeNode(data);
                } else {
                    insertNode(node.right, data);
                }
            }
        }
    }



    public static void main(String[] args) {
        int[] a = {2,4,12,45,21,6,111};

        TreeNode root = buildTree(a);
        System.out.print(bstDistance(a, 6,111));
    }
}
