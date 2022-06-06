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

// TC = O(m) + O(n)
// SC = O(m)
/*
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
*/

class Solution{
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        int a = size(head1);
        int b = size(head2);
        
        if(a>b){
            while(a != b){
                head1 = head1.next;
                a--;
            }
        }
        
        if(b>a){
            while(a != b){
                head2 = head2.next;
                b--;
            }
        }
        
        while(head1 != null){
            if(head1 == head2) return head1;
            head1 = head1.next;
            head2 = head2.next;
        }
        
        return null;
    }
    
    public int size(ListNode node){
        int ans = 0;
        while(node != null){
            node = node.next;
            ans++;
        }
        return ans;
    }
}