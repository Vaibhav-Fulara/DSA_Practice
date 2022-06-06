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
    long max = 0, totSum = 0;
    public int maxProduct(TreeNode root) {
        totSum = sum(root);
        sum(root);
        return (int)(max % (int)(1e9+7));
    }
    public long sum(TreeNode node){
        if(node == null) return 0;
        long summ = node.val + sum(node.left) + sum(node.right);
        max = Math.max(max, summ*(totSum-summ));
        return summ;
    }
}

