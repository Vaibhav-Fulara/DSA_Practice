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
        if(root == null) return;
        flattenTree(root);
    }
    public TreeNode flattenTree(TreeNode root){
        TreeNode left = root.left, right = root.right; 
        TreeNode lt = null, rt = null;
        if(left != null) lt = flattenTree(root.left);
        if(right != null)  rt = flattenTree(root.right);
        
        if(lt == null) return rt == null? root:rt;
        root.left = null;
        root.right = left;
        lt.right = right;
        
        return rt == null? lt:rt;
    }
}