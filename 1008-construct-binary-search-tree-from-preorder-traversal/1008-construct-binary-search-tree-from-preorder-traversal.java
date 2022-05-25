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
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        return getBST(preorder, 0, n-1);
    }
    public TreeNode getBST(int[]pre, int lo, int hi){
        if(lo > hi) return null;
        if(lo == hi) return new TreeNode(pre[lo]);
        
        TreeNode head = new TreeNode (pre[lo]);
        
        int idx = lo + 1;
        while(idx<pre.length && pre[idx] < pre[lo]) idx++;
        
        head.left = getBST(pre, lo + 1, idx-1);
        head.right = getBST(pre, idx, hi);
        return head;
    }
}