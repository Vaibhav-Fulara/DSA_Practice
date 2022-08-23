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
    public boolean isPalindrome(ListNode head) {
        ListNode slo = head;
        ListNode fast = head;
        while(fast!=null && fast.next != null && fast.next.next != null) {
            slo = slo.next;
            fast = fast.next.next;
        }
        ListNode head2 = reverse(slo.next);
        slo.next = null;
        
        while(head != null && head2 != null) {
            if(head.val != head2.val) return false;
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}