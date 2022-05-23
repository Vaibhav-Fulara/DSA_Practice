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
        ListNode lo = head;
        ListNode hi = head;
        while(hi!=null && hi.next!=null && hi.next.next!=null){
            lo = lo.next;
            hi = hi.next.next;
        }
        lo = lo.next;
        ListNode h2 = reverse(lo);
        while(head!=null && h2!=null){
            if(head.val!=h2.val) return false;
            head = head.next;
            h2 = h2.next;
        }
        return true;
    }
    public ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}