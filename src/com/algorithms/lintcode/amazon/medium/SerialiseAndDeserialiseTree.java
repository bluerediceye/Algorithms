package com.algorithms.lintcode.amazon.medium;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created on 17/08/2018
 *
 * @author Ming Li
 */
public class SerialiseAndDeserialiseTree {
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    
    
    public String serialize(TreeNode root) {
        // write your code here
        
        if (root == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            
            TreeNode node = queue.poll();
            
            if (node.left != null) {
                queue.add(node.left);
                sb.append(",").append(node.left.val);
            } else {
                sb.append(",#");
            }
            
            if (node.right != null) {
                queue.add(node.right);
                sb.append(",").append(node.right.val);
            } else {
                sb.append(",#");
            }
        }
        
        return sb.toString();
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data == null || data.isEmpty()) {
            return null;
        }
        
        String[] nodes = data.split(",");
        
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (2 * i + 1 < nodes.length && !nodes[2 * i + 1].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(nodes[2 * i + 1]));
                queue.add(node.left);
            }
            if (2 * i + 2 < nodes.length && !nodes[2 * i + 2].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(nodes[2 * i + 2]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}
