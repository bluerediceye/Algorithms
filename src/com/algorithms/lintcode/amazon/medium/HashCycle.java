package com.algorithms.lintcode.amazon.medium;

/**
 * Created on 15/08/2018
 *
 * @author Ming Li
 */
public class HashCycle {
    public class ListNode {
        int val;
        ListNode next;
        
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    public Boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        do {
            slow = slow.next;
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            
        } while (slow != fast);
        
        return true;
    }
}
