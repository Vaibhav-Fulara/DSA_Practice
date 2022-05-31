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
    int minCount = 0;
    public int minCameraCover(TreeNode root) {
        String str = getCams(root);
        if(str.equals("NM")) minCount++;
        return minCount;
    }
    public String getCams(TreeNode node){
        if(node == null) return "M";
        String left = getCams(node.left);
        String right = getCams(node.right);
        if(left.equals("NM") || right.equals("NM")){
            minCount++;
            return "C";
        }
        if(left.equals("C") || right.equals("C")){
            return "M";
        }
        else return "NM";
    }
}