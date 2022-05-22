/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode lo = head;
        ListNode hi = head;
        while(hi!=null && hi.next!=null){
            lo = lo.next; 
            hi = hi.next.next;
            if(lo == hi) return true;
        }
        return false;
    }
}