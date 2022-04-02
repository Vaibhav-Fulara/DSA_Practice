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
    public boolean isBalanced(TreeNode root) {
        Pair ans = analyze(root);
        return ans.flag;
    }
    
    public Pair analyze(TreeNode root){
        if(root == null) return new Pair(0,true);
        Pair left = analyze(root.left);
        Pair right = analyze(root.right);
        Pair ans = new Pair();
        ans.val = Math.max(left.val, right.val) + 1;
        ans.flag = left.flag && right.flag && Math.abs(left.val-right.val)<=1;
        return ans;
    }
    
    public class Pair{
        int val;
        boolean flag;
        Pair(){};
        Pair(int val) {this.val = val;}
        Pair(boolean flag) {this.flag = flag;}
        Pair(int val, boolean flag){
            this.val = val;
            this.flag = flag;
        }
    }
}