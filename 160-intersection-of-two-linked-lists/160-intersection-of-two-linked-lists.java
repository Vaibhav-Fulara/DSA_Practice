/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        
        int s1 = getSize(l1);
        int s2 = getSize(l2);
        
        while(s1>s2) {l1 = l1.next; s1--;}
        while(s2>s1) {l2 = l2.next; s2--;}
        
        while(l1 != null && l2 != null){
            if(l1 == l2) return l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        return null;
    }
    public int getSize(ListNode node){
        int size = 0;
        while(node != null){
            size++;
            node = node.next;
        }
        return size;
    }
}