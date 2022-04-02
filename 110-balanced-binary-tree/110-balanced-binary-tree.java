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
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        int ans = analyze(root);
        return flag;
    }
    
    public int analyze(TreeNode root){
        if(root == null) return 0;
        int left = analyze(root.left);
        int right = analyze(root.right);
        if(flag==true) flag = Math.abs(left-right)<=1;
        return Math.max(left, right) + 1;        
    }
}