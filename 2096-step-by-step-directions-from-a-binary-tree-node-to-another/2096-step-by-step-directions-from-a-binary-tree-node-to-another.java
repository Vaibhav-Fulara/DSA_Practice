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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder strt = new StringBuilder(), end = new StringBuilder();
        find(root, startValue, strt);
        find(root, destValue, end);
        
        strt.reverse();
        end.reverse();
        
        int i=0;
        while(i < end.length() && i < strt.length() && strt.charAt(i) == end.charAt(i)) i++; 
        
        String ans = "U".repeat(strt.length()-i);
        ans += end.toString().substring(i, end.length());
        return ans;
    }
    private boolean find(TreeNode n, int val, StringBuilder sb) {
        if (n.val == val) return true;
        if (n.left != null && find(n.left, val, sb)) sb.append("L");
        else if (n.right != null && find(n.right, val, sb)) sb.append("R");
        return sb.length() > 0;
    }
}


