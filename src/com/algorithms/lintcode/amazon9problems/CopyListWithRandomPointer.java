package com.algorithms.lintcode.amazon9problems;

/**
 * Created on 09/08/2018
 *
 * @author Ming Li
 */
public class CopyListWithRandomPointer {
    
    class RandomListNode {
        int label;
        RandomListNode next, random;
        
        RandomListNode(int x) {
            this.label = x;
        }
    }
    
    /**
     * @param head: The head of linked list with a random pointer.
     *
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
    
        if (head == null) {
            return null;
        }
        RandomListNode hh = head;
        while(head != null) {
            RandomListNode newNode = new RandomListNode(head.label);
            RandomListNode next = head.next;
            head.next = newNode;
            newNode.next = next;
            head = head.next.next;
        }
        
        head = hh;
        while(head != null){
            head.next.random = head.random.next;
            head = head.next.next;
        }
        
        head = hh;
        RandomListNode copiedHead = head.next;
        while(head != null){
            copiedHead.next = copiedHead.next.next;
            head = head.next.next;
        }
        
        return copiedHead;
    }
}
