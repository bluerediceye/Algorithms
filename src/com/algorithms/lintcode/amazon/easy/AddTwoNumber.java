package com.algorithms.lintcode.amazon.easy;

/**
 * Created on 15/08/2018
 *
 * @author Ming Li
 */
public class AddTwoNumber {
    public ListNode addLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        
        if (l1 == null) {
            return l2;
        }
        
        if (l2 == null) {
            return l1;
        }
        
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode point = dummy;
        
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int left = sum % 10;
            carry = sum / 10;
            
            point.next = new ListNode(left);
            l1 = l1.next;
            l2 = l2.next;
            point = point.next;
        }
        
        while (l1 != null) {
            int sum = carry + l1.val;
            int left = sum % 10;
            carry = sum / 10;
            point.next = new ListNode(left);
            l1 = l1.next;
            point = point.next;
        }
        
        while (l2 != null) {
            int sum = carry + l2.val;
            int left = sum % 10;
            carry = sum / 10;
            point.next = new ListNode(left);
            l2 = l2.next;
            point = point.next;
        }
        
        if (carry != 0) {
            point.next = new ListNode(carry);
        }
        
        return dummy.next;
    }
    
    public class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
