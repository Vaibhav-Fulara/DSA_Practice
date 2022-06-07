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
    int i = 0;
    public TreeNode recoverFromPreorder(String traversal) {
        return traverse(traversal, 0);
    }
    public TreeNode traverse (String str, int val){
        int dash=0;
        while(i + dash < str.length() && str.charAt(i + dash) == '-') dash++;
        if(dash != val) return null;
        
        int num = 0;
        while(i + dash + num < str.length() && str.charAt(i + dash + num) != '-') num++;
        
        int curr = Integer.parseInt(str.substring(i+dash, i+dash+num));
        TreeNode root = new TreeNode(curr);
        
        i += dash + num;
        
        root.left = traverse(str, val+1);
        if(root.left != null) root.right= traverse(str, val+1);
        
        return root;
    }
}