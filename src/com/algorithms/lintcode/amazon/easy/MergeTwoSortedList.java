package com.algorithms.lintcode.amazon.easy;

/**
 * Created on 15/08/2018
 *
 * @author Ming Li
 */
public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        
        if (l1 == null) {
            return l2;
        }
        
        if (l2 == null) {
            return l1;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode point = dummy;
        while (l1 != null && l2 != null) {
            while (l1 != null && l2 != null && l1.val <= l2.val) {
                point.next = new ListNode(l1.val);
                l1 = l1.next;
                point = point.next;
            }
            
            while (l1 != null && l2 != null && l1.val >= l2.val) {
                point.next = new ListNode(l2.val);
                l2 = l2.next;
                point = point.next;
            }
        }
        
        if (l1 != null) {
            point.next = l1;
        }
        
        if (l2 != null) {
            point.next = l2;
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
