package com.algorithms.lintcode.amazon.easy;

/**
 * Created on 15/08/2018
 *
 * @author Ming Li
 */
public class ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
