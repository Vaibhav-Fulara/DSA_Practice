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
/*
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
*/

// O(n)

class Solution{
    
    private ListNode node;

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;

        int size = 0;
        ListNode temp = head;
        node = head;

        while(temp != null){
            temp = temp.next;
            size ++;
        }

        return inorderHelper(0, size - 1);
    }

    public TreeNode inorderHelper(int start, int end){
        if(start > end)  return null;

        int mid = start + (end - start) / 2;
        TreeNode left = inorderHelper(start, mid - 1);

        TreeNode treenode = new TreeNode(node.val);
        treenode.left = left;
        node = node.next;

        TreeNode right = inorderHelper(mid + 1, end);
        treenode.right = right;

        return treenode;
    }
}