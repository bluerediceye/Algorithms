package com.algorithms.stack;

import com.algorithms.queue.Queue;

/**
 * Created on 21/03/2017
 *
 * @author Ming Li
 */
public class Stack {

    private Node head;
    private int num;


    public void push(int v){

        num++;
        if(head == null){
            head = new Node(v);
            return;
        }

        Node temp = head;
        head = new Node(v);
        head.next = temp;

    }

    public Integer pop(){
        if(head == null){
            return null;
        }
        num--;
        int temp = head.value;
        head = head.next;
        return temp;
    }

    class Node {
        Node next;
        private Integer value;

        public Node(Integer value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3};
        Stack stack = new Stack();
        for (int value : values) {
            stack.push(value);
        }

        Integer v;
        do {
            v = stack.pop();
            System.out.print(v + " ");
            System.out.println("Number of stack: " + stack.num);
        } while (v != null);
        System.out.println();
    }


}
