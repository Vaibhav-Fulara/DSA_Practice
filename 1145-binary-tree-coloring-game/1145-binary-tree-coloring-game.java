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
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        if(root == null) return false;
        if(root.val == x){
            int left = getSize(root.left);
            int right = getSize(root.right);
            int parent = n-(left + right + 1);
            if(parent > left + right +1 || left > parent + right || right > parent + left) return true;
        }
        return btreeGameWinningMove(root.left, n, x) || btreeGameWinningMove(root.right, n, x);
    }
    
    public int getSize(TreeNode root){
        if(root == null) return 0;
        int left = getSize(root.left);
        int right = getSize(root.right);
        return left + right + 1;
    }
}