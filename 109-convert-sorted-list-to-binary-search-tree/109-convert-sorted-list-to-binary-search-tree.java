// O(n^2) 
/*
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
*/

// O(nlogn)

class Solution{
    public TreeNode sortedListToBST(ListNode head){
        if(head == null) return null;
        return helper(head, null);
    }
    public TreeNode helper(ListNode head, ListNode tail){
        if(head == tail) return null;
        
        ListNode slo = head;
        ListNode fast = head;
        
        while(fast != tail && fast.next != tail){
            fast = fast.next.next;
            slo = slo.next;
        }
        
        TreeNode node = new TreeNode(slo.val);
        node.left = helper(head, slo);
        node.right = helper(slo.next, tail);
        
        return node;
    }
}