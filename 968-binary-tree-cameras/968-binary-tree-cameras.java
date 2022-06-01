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
    int count = 0;
    public int minCameraCover(TreeNode root) {
        String str = getCount(root);
        if(str.equals("NM")) count++;
        return count;
    }
    public String getCount(TreeNode root){
        if(root == null) return "M";
        String left = getCount(root.left);
        String right = getCount(root.right);
        if(left.equals("NM") || right.equals("NM")) {count++;  return "C";}
        if(left.equals("C") || right.equals("C")) return "M";
        return "NM";
    }
}