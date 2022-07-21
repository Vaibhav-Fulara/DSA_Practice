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
    public ListNode mergeNodes(ListNode head) {
        ListNode ans = new ListNode(-1);
        ListNode temp = ans;
        head = head.next;
        int curr = 0;
        
        while(head != null) {
            while(head.val != 0) {
                curr += head.val;
                head = head.next;
            }
            temp.next = new ListNode(curr);
            temp = temp.next;
            head = head.next;
            curr = 0;
        }
        return ans.next;
    }
}