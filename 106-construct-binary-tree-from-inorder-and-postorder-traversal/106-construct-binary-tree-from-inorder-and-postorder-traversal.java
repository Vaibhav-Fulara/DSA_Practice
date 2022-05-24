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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        Map<Integer, Integer>hm = new HashMap<>();
        for(int i=0; i<n; i++) hm.put(inorder[i], i);
        return getTree(0,n-1,0,n-1,postorder,hm);
    }
    public TreeNode getTree(int in_l, int in_r, int post_l, int post_r, int[]post, Map<Integer, Integer>hm){
        if(in_r < in_l || post_l > post_r) return null;
        TreeNode head = new TreeNode (post[post_r]);
        
        int idx = hm.get(head.val);
        int rhs = in_r-idx;
        
        head.left = getTree(in_l, idx-1, post_l, post_r - rhs -1, post, hm);
        head.right = getTree(idx+1, in_r, post_r - rhs, post_r - 1, post, hm);
        return head;
    }
}