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
    public int sumEvenGrandparent(TreeNode root) {
        int ans = 0;
        return getSum(root);
    }
    public int getSum(TreeNode node){
        if(node == null) return 0;
        int ans = 0;
        
        if(node.val%2 == 0){
            if(node.left != null && node.left.left != null) ans += node.left.left.val;
            if(node.left != null && node.left.right != null) ans += node.left.right.val;
            if(node.right != null && node.right.left != null) ans += node.right.left.val;
            if(node.right != null && node.right.right != null) ans += node.right.right.val;
        }
        
        ans += getSum(node.left);
        ans += getSum(node.right);
        
        return ans;
    }
}