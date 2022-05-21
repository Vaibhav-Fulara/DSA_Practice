/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = 0;
        ListNode head = new ListNode(-1);
        ListNode iter = head;
        while(l1 != null && l2 != null){
            int val = l1.val + l2.val + temp;
            iter.next = new ListNode(val % 10);
            iter = iter.next;
            temp = val/10;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null){
            int val = l1.val + temp;
            iter.next = new ListNode(val % 10);
            iter = iter.next;
            temp = val/10;
            l1 = l1.next;
        }
        
        while(l2 != null){
            int val = l2.val + temp;
            iter.next = new ListNode(val % 10);
            iter = iter.next;
            temp = val/10;
            l2 = l2.next;
        }
        
        if(temp != 0) iter.next = new ListNode(temp);
        return head.next;
    }
}