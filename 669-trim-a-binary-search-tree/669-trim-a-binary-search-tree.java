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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return getTrim(root, low, high, null);
    }
    
    public TreeNode getTrim(TreeNode root, int low, int hi, TreeNode parent){
        if (root == null) return root;
        if(root.val < low){
            TreeNode right = getTrim (root.right, low, hi, parent);
            if (parent == null) return right;
            else return parent.right = right;
        }
        else if(root.val > hi){
            TreeNode left = getTrim (root.left, low, hi, parent);
            if (parent == null) return left;
            else return parent.left = left;
        }
        else{
            TreeNode left = getTrim (root.left, low, hi, parent);
            TreeNode right = getTrim (root.right, low, hi, parent);
            root.left = left;
            root.right = right;
        }
        parent = root;
        return root;
    }
}