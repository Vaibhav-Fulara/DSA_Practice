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
    public ListNode middleNode(ListNode head) {
        ListNode lo = head, hi = head;
        while(hi!=null && hi.next!=null){
            lo = lo.next;
            hi = hi.next.next;
        }
        return lo;
    }
}