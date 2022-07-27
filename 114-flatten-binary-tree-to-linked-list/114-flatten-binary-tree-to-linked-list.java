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
    public void flatten(TreeNode root) {
        flattenTree(root);
    }
    public TreeNode flattenTree(TreeNode root) {
        if(root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        TreeNode lt = flattenTree(root.left);
        TreeNode rt = flattenTree(root.right);
        
        if(lt == null) return rt == null? root:rt;
        root.left = null;
        root.right = left;
        lt.right = right;
        
        return rt == null ? lt:rt;
    }
}