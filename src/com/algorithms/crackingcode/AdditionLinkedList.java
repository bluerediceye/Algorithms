package com.algorithms.crackingcode;

/**
 * Created on 23/03/2017
 *
 * @author Ming Li
 */
public class AdditionLinkedList {


    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }


    private Node head;

    public Node add(Node a, Node b){
        add(a, b, 0, null);
        return head;
    }

    public void add(Node a, Node b, int x, Node previous){

        if(previous == null){
            int carryOver = (a.value + b.value) / 10;
            int leftOver = (a.value + b.value) % 10;
            head = new Node(leftOver);
            add(a.next,b.next, carryOver, head);
            return;
        }


        if(a==null && b==null){
            if(x != 0){
                previous.next = new Node(x);
                return;
            }else{
                return;
            }
        }

        int carryOver = ((a== null ? 0: a.value) + (b==null?0:b.value) + x) / 10;
        int leftOver = ((a== null ? 0: a.value) + (b==null?0:b.value) + x) % 10;

        previous.next = new Node(leftOver);
        add(a==null ? null :a.next, b==null?null: b.next, carryOver, previous.next);
    }

    public Node add2(Node a, Node b, int carry){
        if(a==null && b==null){
            return null;
        }

        Node c = new Node(carry);
        if(head ==null){
            head = c;
        }
        int value = carry;
        if(a!=null){
            value += a.value;
        }
        if(b!=null){
            value += b.value;
        }

        c.value = value % 10;
        c.next = add2(a==null?null:a.next, b==null?null:b.next, value/10);
        return c;
    }


    public static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(1);
        Node c = new Node(5);
        Node d = new Node(9);
        a.next = b;
        b.next = c;
        c.next = d;

        Node aa = new Node(5);
        Node bb = new Node(9);
        Node cc = new Node(2);
        Node dd = new Node(9);
        aa.next = bb;
        bb.next = cc;
        cc.next = dd;

        AdditionLinkedList add = new AdditionLinkedList();
        add.add(a, aa, 0, null);
//        add.add2(a, aa, 0);

       Node current = add.head;
       while(current!=null){
           System.out.print(current.value + (current.next !=null? "->":""));
           current = current.next;
       }
    }

}
