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
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        helper(root, -1);
        return max == 0 ? 0:max-1;
    }
    public int helper(TreeNode node, int val){
        if(node == null) return 0;
        
        int left = helper(node.left, node.val);
        int right = helper(node.right, node.val);
        
        if(left + right + 1 > max) max = left + right + 1;
        if(val == node.val) return Math.max(left, right) + 1;
        return 0;
    }
}
