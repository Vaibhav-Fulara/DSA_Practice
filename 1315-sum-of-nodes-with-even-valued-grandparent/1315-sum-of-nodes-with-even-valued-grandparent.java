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
        return getSum(root, -1, -1);
    }
    public int getSum(TreeNode node, int par, int grandPar){
        if(node == null) return 0;
        int ans = 0;
        
        if(grandPar % 2 == 0) ans += node.val;
        
        grandPar = par;
        par = node.val;
        
        ans += getSum(node.left, par, grandPar);
        ans += getSum(node.right, par, grandPar);
        
        return ans;
    }
}