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
    public int pairSum(ListNode head) {
        Stack<Integer>st = new Stack<>();
        ListNode temp = head;
        while(temp!=null) {st.push(temp.val); temp = temp.next;}
        int n = st.size()/2;
        int ans = head.val;
        temp = head;
        for(int i=0; i<n; i++) {
            ans = Math.max(temp.val + st.pop(), ans);
            temp = temp.next;
        }
        return ans;
    }
}