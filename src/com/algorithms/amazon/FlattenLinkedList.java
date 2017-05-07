package com.algorithms.amazon;

/**
 * Created on 21/04/2017
 *
 * @author Ming Li
 */
public class FlattenLinkedList {

    Node head;

    static class Node {
        int data;
        Node down, right;

        public Node(int data) {
            this.data = data;
        }
    }

    public void push(int data){
        Node node = new Node(data);
        node.right = head;
        head = node;
    }



}
