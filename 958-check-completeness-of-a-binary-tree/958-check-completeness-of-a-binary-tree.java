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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode>qu = new ArrayDeque<>();
        qu.add(root);
        boolean bool = false;
        while(!qu.isEmpty()){
            TreeNode temp = qu.remove();
            if(temp.left == null) bool = true;
            if(temp.left != null) {
                if (bool) return false;
                qu.add(temp.left);
            }
            if(temp.right == null) bool = true;
            if(temp.right != null) {
                if (bool) return false;
                qu.add(temp.right);
            }
        }
        return true;
    }
}