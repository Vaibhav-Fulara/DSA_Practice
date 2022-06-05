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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        int n = height(head);
        if(n==1) return new TreeNode(head.val);
        
        ListNode right = head;
        
        int k = n/2;
        
        while(k > 1){
            right = right.next;
            k--;
        }
        
        ListNode mark = right.next.next;
        TreeNode node = new TreeNode(right.next.val);
        
        right.next = null;
        
        
        node.left = sortedListToBST(head);
        if(mark!=null) node.right = sortedListToBST(mark);
        
        return node;
    }
    
    public int height(ListNode root){
        int ans = 0;
        while(root != null){
            ans++;
            root = root.next;
        }
        return ans;
    }
}