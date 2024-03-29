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
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        solve(root, sb);
        return sb.toString();
    }
    public void solve(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("()");
            return;
        }
        sb.append(root.val);
        if(root.left == null && root.right == null) return;
        if(root.left != null && root.right != null) {
            sb.append("(");
            solve(root.left, sb);
            sb.append(")");
            sb.append("(");
            solve(root.right, sb);
            sb.append(")");
        } else if(root.left != null) {
            sb.append("(");
            solve(root.left, sb);
            sb.append(")");
        } else if(root.right != null) {
            sb.append("()(");
            solve(root.right, sb);
            sb.append(")");
        }        
    }
}