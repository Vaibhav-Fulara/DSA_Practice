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
    public ListNode partition(ListNode head, int x) {
        Set<ListNode>hs = new HashSet<>();
        ListNode iter = head;
        ListNode ans = new ListNode(-1), temp = ans;
        while(iter != null) {
            if(iter.val < x) {
                temp.next = new ListNode(iter.val);
                hs.add(iter);
                temp = temp.next;
            }
            iter = iter.next;
        }
        iter = head;
        while(iter != null){
            if(iter.val >= x) {
                temp.next = new ListNode(iter.val);
                temp = temp.next;
            }
            iter = iter.next;
        }
        
        return ans.next;
    }
}