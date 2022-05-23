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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k==0) return head;
        int len = getSize(head);
        k %= len;
        if(k == 0) return head;
        
        ListNode left = head;
        ListNode right = head;
        while(k != 0) {
            right = right.next;
            k--;
        }
        while(right.next != null){
            right = right.next;
            left = left.next;
        }
        right.next = head;
        ListNode ans = left.next;
        left.next = null;
        return ans;
    }
    public int getSize(ListNode node){
        int size = 0;
        while(node!=null){
            node = node.next;
            size++;
        }
        return size;
    }
}