package com.algorithms.queue;

/**
 * Created on 21/03/2017
 *
 * @author Ming Li
 */
public class Queue<T> {
    
    private Node<T> head;
    private Node<T> end;
    private int num = 0;
    
    public static void main(String[] args) {
        int[] values = {1, 2, 3};
        Queue<Integer> queue = new Queue<>();
        for (int value : values) {
            queue.add(value);
        }
        
        Integer v;
        do {
            v = queue.poll();
            System.out.print(v + " ");
            System.out.println("Number of queue: " + queue.num);
        } while (v != null);
        System.out.println();
    }
    
    public void add(T value) {
        num++;
        
        if (head == null) {
            head = end = new Node<>(value);
            head.next = null;
            head.previous = null;
            return;
        }
        
        Node<T> node = new Node<>(value);
        end.next = node;
        node.previous = end;
        end = node;
    }
    
    public T poll() {
        if (head == null) {
            return null;
        }
        num--;
        T temp = head.value;
        if (head.next != null) {
            head.next.previous = null;
        }
        head = head.next;
        return temp;
    }
    
    class Node<S> {
        S value;
        Node<S> next;
        Node<S> previous;
        
        public Node(S value) {
            this.value = value;
        }
    }
}
