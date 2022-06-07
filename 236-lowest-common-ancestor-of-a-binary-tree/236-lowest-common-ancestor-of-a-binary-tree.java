/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    boolean f1 = false, f2 = false;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        TreeNode ans = helper(root, p, q);
        return f1 && f2 ? ans:null;
    }
    
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;
        
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);
        
        if(p == root) {
            f1 = true;
            return root;
        }
        else if(q == root){
            f2 = true;
            return root;
        }
        else if(left != null && right != null) return root;
        return left != null ? left:right;
    }
}