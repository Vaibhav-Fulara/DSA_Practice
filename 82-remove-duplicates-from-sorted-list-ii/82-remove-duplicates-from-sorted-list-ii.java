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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ans = new ListNode(-1, head);
        ListNode temp = ans;
        while(temp != null && temp.next != null && temp.next.next != null){
            ListNode pointer = temp.next;
            if(pointer.next.val == pointer.val) {
                while(pointer.next != null && pointer.next.val == pointer.val) pointer = pointer.next;
                temp.next = pointer.next;
            } else {
                temp = temp.next;
            }
        }
        return ans.next;
    }
}