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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = head;
        ListNode right = head;
        if(n==1){
            if(head.next == null) return null;
            while(right.next.next!=null) right = right.next;
            right.next = null;
            return head;
        }
        while(n != 1){
            right = right.next;
            n--;
        }
        while(right != null && right.next != null){
            left = left.next;
            right = right.next;
        }
        left.val = left.next.val;
        left.next = left.next.next;
        return head;
    }
}