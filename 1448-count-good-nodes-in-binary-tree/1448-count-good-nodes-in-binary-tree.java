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
    int cont =0;
    public int goodNodes(TreeNode root) {
        getCount(root, Integer.MIN_VALUE);
        return cont;
    }
    public void getCount(TreeNode root, int max){
        if(root==null) return;
        if(root.val>=max){
            max = root.val;
            cont++;
        }
        getCount(root.left, max);
        getCount(root.right, max);
    }
}