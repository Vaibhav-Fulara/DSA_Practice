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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        
        int left = 0, right = 0;
        
        TreeNode node = root.left;
        while(node != null){
            node = node.left;
            left++;
        }
        
        node = root.right;
        while(node != null){
            node = node.right;
            right++;
        }
           
        if(left == right) {
            left ++;
            return (1 << left) - 1;
        }
        
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}