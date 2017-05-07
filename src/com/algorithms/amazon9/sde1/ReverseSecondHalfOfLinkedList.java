package com.algorithms.amazon9.sde1;

/**
 * Created on 01/03/2017
 *
 * @author Ming Li
 */
public class ReverseSecondHalfOfLinkedList {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode seven = new ListNode(7);
        ListNode eight = new ListNode(8);

        one.setNext(two);
        two.setNext(three);
        three.setNext(four);
        four.setNext(five);
        five.setNext(six);
        six.setNext(seven);
        seven.setNext(eight);

        print(one);
        print(resolve(one));

    }

    public static ListNode resolve(ListNode head) {


        if (head == null || head.next == null) {
            return head;
        }


        ListNode slow = head;
        ListNode fast = head.next;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode cur = slow.next;
        ListNode pre = null;


        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        slow.next = pre;

        return head;
    }

    public static void print(ListNode head) {
        if (head != null) {

            ListNode cur = head;

            while (cur != null) {
                System.out.print(cur);
                if (cur.next != null) {
                    System.out.print("->");
                }

                cur = cur.next;
            }

            System.out.println();
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public void setNext(ListNode node) {
            this.next = node;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
