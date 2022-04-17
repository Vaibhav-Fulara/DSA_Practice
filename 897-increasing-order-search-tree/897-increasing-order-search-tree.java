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
    public TreeNode increasingBST(TreeNode root) {
        return getBST(root, null);
    }

    public TreeNode getBST(TreeNode root, TreeNode tail) {
        if (root == null) return tail;
        TreeNode temp = getBST(root.left, root);
        root.left = null;
        root.right = getBST(root.right, tail);
        return temp;
    }
}