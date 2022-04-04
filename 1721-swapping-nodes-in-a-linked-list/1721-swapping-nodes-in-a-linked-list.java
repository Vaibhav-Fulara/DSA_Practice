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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slo = head;
        ListNode fast = head;
        k-=1;
        while(k>0) {fast = fast.next; k--;}
        ListNode node1 = fast;
        while(fast.next!=null){
            slo = slo.next;
            fast = fast.next;
        }
        ListNode node2 = slo;
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
        return head;
    }
}