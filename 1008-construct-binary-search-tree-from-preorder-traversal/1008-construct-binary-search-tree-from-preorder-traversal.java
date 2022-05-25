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
    int idx = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return getBST(preorder, Integer.MAX_VALUE);
    }
    public TreeNode getBST(int[]pre, int hi){
        if(idx == pre.length) return null;
        else if(pre[idx] < hi){
            TreeNode node = new TreeNode(pre[idx++]);
            node.left = getBST(pre, node.val);
            node.right = getBST(pre, hi);
            return node;
        }
        return null;
    }
}