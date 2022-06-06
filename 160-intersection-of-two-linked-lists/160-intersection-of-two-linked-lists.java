/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        Set<ListNode>hs = new HashSet<>();
        while(head1 != null){
            hs.add(head1);
            head1 = head1.next;
        }
        while(head2 != null){
            if(hs.contains(head2)) return head2;
            head2 = head2.next;
        }
        return null;
    }
}