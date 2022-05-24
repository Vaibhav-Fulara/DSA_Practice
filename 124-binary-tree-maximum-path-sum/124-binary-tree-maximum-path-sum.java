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
    int maxComb = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxComb = Integer.MIN_VALUE;
        getAns(root);
        return maxComb;
    }
    
    public int getAns(TreeNode root){
        if(root == null) return 0;
        int left =  getAns(root.left);
        int right = getAns(root.right);
        
        left = Math.max(0, left);
        right = Math.max(0, right);
        
        maxComb = Math.max(maxComb, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}