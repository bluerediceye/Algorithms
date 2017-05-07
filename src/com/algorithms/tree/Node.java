package com.algorithms.tree;

/**
 * Created on 15/03/2017
 *
 * @author Ming Li
 */
public class Node {
    int value;
    Node left;
    Node right;

    Node(int value){
        this.value = value;
    }

    Node(int value, Node left, Node right){
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
