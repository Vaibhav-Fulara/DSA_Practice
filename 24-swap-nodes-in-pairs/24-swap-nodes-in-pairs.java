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
    public ListNode swapPairs(ListNode node) {
        if(node == null || node.next == null) return node;
        ListNode slo = node, fast = node, prev = null;
        while(fast != null && fast.next != null){
            fast = fast.next;
            ListNode far = fast.next;
            
            fast.next = slo;
            if(prev == null) node = fast;
            else prev.next = fast;
            slo.next = far;
            
            prev = slo;
            fast = far;
            slo = far;
        }
        return node;
    }
}