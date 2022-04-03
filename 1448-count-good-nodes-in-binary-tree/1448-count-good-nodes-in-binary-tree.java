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
    public int goodNodes(TreeNode root) {
        return getCount(root, Integer.MIN_VALUE);
    }
    public int getCount(TreeNode root, int max){
        if(root==null) return 0;
        int cont = 0;
        if(root.val>=max){
            max = root.val;
            cont = 1;
        }
        int left = getCount(root.left, max);
        int right = getCount(root.right, max);
        return left+right+cont;
    }
}