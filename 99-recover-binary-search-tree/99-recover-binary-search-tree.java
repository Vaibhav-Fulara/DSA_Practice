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
    TreeNode prev;
    TreeNode curr;
    TreeNode mid;
    
    public void recoverTree(TreeNode root) {
        iterate(root);
        int temp = curr.val;
        curr.val = mid.val;
        mid.val = temp;
    }
    
    public void iterate(TreeNode root){
        if(root == null) return;
        iterate(root.left);
        if(prev != null){
            if(root.val < prev.val){
                if(mid == null) mid = prev;
                curr = root;
            }
        }
        prev = root;
        iterate(root.right);
    }
}