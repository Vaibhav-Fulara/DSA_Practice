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
        String s = getMinCameras(root);
        if(s.equals("NM")) return count + 1;
        return count;
    }
    public String getMinCameras(TreeNode root){
        if(root == null) return "M";
        String left = getMinCameras(root.left);
        String right = getMinCameras(root.right);
        if(left.equals("C") && right.equals("C")) return "M";
        else if(left.equals("C") || right.equals("C")){
            if(left.equals("NM") || right.equals("NM")){
                count ++;
                return "C";
            }
            else return "M";
        }
        if(left.equals("M") && right.equals("M")) return "NM";
        else{
            count ++;
            return "C";
        }
    }
}