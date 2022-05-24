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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        HashMap<Integer, Integer>hm = new HashMap<>();
        for(int i=0; i<inorder.length; i++) hm.put(inorder[i], i);
        
        int n = preorder.length;
        return getTree(preorder, 0, n-1, 0, n-1, hm);
    }
    public TreeNode getTree(int[]preorder, int pre_lo, int pre_hi, int in_lo, int in_hi, HashMap<Integer, Integer>hm){
        if(pre_lo > pre_hi || in_lo > in_hi) return null;
        
        TreeNode head = new TreeNode(preorder[pre_lo]);
        
        int idx = hm.get(preorder[pre_lo]);
        int lhs = idx - in_lo;
        
        head.left = getTree(preorder, pre_lo + 1, pre_lo + lhs, in_lo, idx-1, hm);
        head.right = getTree(preorder, pre_lo + lhs +1, pre_hi, idx+1, in_hi, hm);
        return head;
    }
}