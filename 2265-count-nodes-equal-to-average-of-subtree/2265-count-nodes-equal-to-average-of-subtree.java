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
    public int averageOfSubtree(TreeNode root) {
        int[]arr = getAverageCount(root);
        return arr[2];
    }
    public int[] getAverageCount(TreeNode root){
        if(root==null) return new int[]{0,0,0};
        int[]ans = new int[3];
        int[]left = getAverageCount(root.left);
        int[]right = getAverageCount(root.right);
        ans[0] = left[0]+right[0]+1;
        ans[1] = left[1]+right[1]+root.val;
        ans[2] = left[2]+right[2];
        if(ans[1]/ans[0] == root.val) ans[2]++;
        return ans;
    }
}