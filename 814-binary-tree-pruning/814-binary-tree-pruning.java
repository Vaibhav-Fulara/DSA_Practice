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
    public TreeNode pruneTree(TreeNode root) {
        if(!solve(root)) return root;
        return null;
    }
    public boolean solve(TreeNode root) {
        if(root == null) return true;
        boolean b1 = solve(root.left);
        if(b1) root.left = null;
        boolean b2 = solve(root.right);
        if(b2) root.right = null;
        if(b1 && b2 && root.val == 0) return true;
        return false;
    }
}