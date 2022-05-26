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
    public int rob(TreeNode root) {
        pair p = getMaxAmount(root);
        return Math.max(p.pick, p.npick);
    }
    public pair getMaxAmount(TreeNode root){
        if(root == null) return new pair(0,0);
        pair left = getMaxAmount(root.left);
        pair right = getMaxAmount(root.right);
        
        return new pair(left.npick + right.npick + root.val, Math.max(left.pick, left.npick) + Math.max(right.pick, right.npick));
    }
    public class pair{
        int pick;
        int npick;
        pair(int s, int b){
            this.pick = s;
            this.npick = b;
        }
    }
}
