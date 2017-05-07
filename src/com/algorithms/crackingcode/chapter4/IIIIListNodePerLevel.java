package com.algorithms.crackingcode.chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created on 29/03/2017
 *
 * @author Ming Li
 */
public class IIIIListNodePerLevel {

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int x) {
            this.value = x;
        }
    }

    public int getNodeDepth(Node root, Node a){
        if(root == null){
            return -1;
        }

        if(root == a){
            return 0;
        }

        int left = getNodeDepth(root.left , a);
        int right = getNodeDepth(root.right , a);

        if(left == -1 && right ==-1){
            return -1;
        }

       return left != -1 ? left + 1: right + 1;
    }

    public List<List<Node>> generate(Node a){
        List<List<Node>> links = new ArrayList<>();

        List<Node> link = new ArrayList<>();
        int level = 0;
        link.add(a);
        links.add(link);


        while(true){

            if(links.get(level).isEmpty()){
                break;
            }

            List<Node> nodes = new ArrayList<>();
            for(int i=0;i<links.get(level).size();i++){

                Node current = links.get(level).get(i);
                if(current.left != null){
                    nodes.add(current.left);
                }
                if(current.right != null){
                    nodes.add(current.right);
                }
            }
            links.add(nodes);
            level++;

        }

        return links;
    }

    public List<List<Node>> levelTraverse(Node a) {
        List<List<Node>> links = new LinkedList<>();

        if (a != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(a);
            while (!queue.isEmpty()) {

                Node current = queue.poll();
                int level = getNodeDepth(a, current);

                if(links.size() - 1 < level){
                    List<Node> link = new LinkedList<>();
                    link.add(current);
                    links.add(level, link);
                }else{
                    links.get(level).add(current);
                }

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }

        }

        return links;
    }

    /**
     *             9
     *            / \
     *          3    4
     *         / \  / \
     *        2  1 5  6
     *               / \
     *              9   0
     *
     *            8
     *           / \
     *          5   7
     *         /     \
     *        1       2
     */
    public static void main(String[] args) {
        Node root = new Node(9);
        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(2);
        Node d = new Node(1);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(9);
        Node h = new Node(0);

        Node aa = new Node(8);
        Node bb = new Node(5);
        Node cc = new Node(7);
        Node dd = new Node(1);
        Node ee = new Node(2);

        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        f.left = g;
        f.right = h;

        aa.left = bb;
        aa.right = cc;
        bb.left = dd;
        cc.right = ee;

        d.right = aa;

        List<List<Node>> links = new IIIIListNodePerLevel().levelTraverse(root);
        List<List<Node>> links2 = new IIIIListNodePerLevel().generate(root);

        for(List<Node> link:links){
            for(Node node : link){
                System.out.print(node.value + "->");
            }
            System.out.println();
        }

        System.out.println();

        for(List<Node> link:links2){
            for(Node node : link){
                System.out.print(node.value + "->");
            }
            System.out.println();
        }

        System.out.println("Distance from root: " + new IIIIListNodePerLevel().getNodeDepth(root, b));
    }
}
