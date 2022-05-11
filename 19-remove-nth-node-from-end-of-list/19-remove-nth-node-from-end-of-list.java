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
        if(n==1){
            ListNode temp = head;
            if(head.next==null) return null;
            while(head.next.next!=null) head = head.next;
            head.next = head.next.next;
            return temp;
        }
        ListNode lo = head;
        ListNode hi = head;
        n--;
        while(n!=0) {hi = hi.next; n--;}
        while(hi.next!=null){
            lo = lo.next;
            hi = hi.next;
        }
        lo.val = lo.next.val;
        lo.next = lo.next.next;
        return head;
    }
}