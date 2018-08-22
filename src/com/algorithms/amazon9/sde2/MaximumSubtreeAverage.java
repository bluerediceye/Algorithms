package com.algorithms.amazon9.sde2;

import java.util.ArrayList;

/**
 * Created on 03/03/2017
 * <p>
 * 就是给一棵多叉树，表示公司内部的上下级关系。每个节点表示一个员工，节点包含的成员是他工作了几个月(int)，
 * 以及一个下属数组(ArrayList)。 目标就是找到一棵子树，满足：这棵子树所 有节点的工作月数的平均数是所有子树中最大的。
 * 最后返回这棵子树的根节点。这题补充一点，返回的不能是叶子节点(因为叶子节点没有下属)，一定要是一个有子节点的节点。
 *
 * @author Ming Li
 */
public class MaximumSubtreeAverage {
    static Node ans;
    static double max = 0;
    
    public static Node find(Node root) {
// Initialize static variables is very important for AMZAON OA!
        ans = null;
        max = 0;
        DFS(root);
        return ans;
    }

    private static SumCount DFS(Node root) {
        if (root == null) {
            return new SumCount(0, 0);
        }
        if (root.children == null || root.children.size() == 0) {
            return new SumCount(root.val, 1);
        }
        int sum = root.val;
        int count = 1;
        for (Node itr : root.children) {
            SumCount sc = DFS(itr);
            sum += sc.sum;
            count += sc.count;
        }
        if (count > 1 && (sum + 0.0) / count > max) {
            max = (sum + 0.0) / count;
            ans = root;
        }
        return new SumCount(sum, count);
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        Node l21 = new Node(2);
        Node l22 = new Node(3);
        Node l23 = new Node(4);
        Node l31 = new Node(5);
        Node l32 = new Node(5);
        Node l33 = new Node(5);
        Node l34 = new Node(5);
        Node l35 = new Node(5);
        Node l36 = new Node(5);
        l21.children.add(l31);
        l21.children.add(l32);
        l22.children.add(l33);
        l22.children.add(l34);
        l23.children.add(l35);
        l23.children.add(l36);
        root.children.add(l21);
        root.children.add(l22);
        root.children.add(l23);
        Node res = find(root);
        System.out.println(res.val + " " + max);
    }
    
    static class Node {
        int val;
        ArrayList<Node> children;
        
        public Node(int val) {
            this.val = val;
            children = new ArrayList<Node>();
        }
    }
    
    static class SumCount {
        int sum;
        int count;
        
        public SumCount(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }
}
