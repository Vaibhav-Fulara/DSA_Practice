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
    public ListNode detectCycle(ListNode head) {
        ListNode temp = getInter(head);
        if(temp == null) return temp;
        
        ListNode curr = head;
        while(curr != temp){
            temp = temp.next;
            curr = curr.next;
        }
        return curr;
    }
    public ListNode getInter(ListNode head){
        ListNode slo = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slo = slo.next;
            fast = fast.next.next;
            if(slo == fast)  return slo;
        }
        return null;
    }
}