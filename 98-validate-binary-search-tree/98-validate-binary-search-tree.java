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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        if(!isValidBST(root.left)) return false;
        if(!isValidBST(root.right)) return false;
        
        TreeNode left = null, right = null;
        
        if(root.left != null) {
            left = root.left;
            while(left.right != null) left = left.right;
        }
        
        if(root.right != null) {
            right = root.right;
            while(right.left != null) right = right.left;
        }
        
        if(right == null && root.val > left.val) return true;
        else if(left == null && root.val < right.val) return true;
        else if(left != null && right != null && root.val > left.val && right.val > root.val) return true;
        
        return false;
    }
}