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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>al = new ArrayList<>();
        TreeNode node = root;
        while(node != null) {
            if(node.left == null) {
                al.add(node.val);
                node = node.right;
            }
            else {
                TreeNode temp = node.left;
                while(temp.right != null && temp.right != node) temp = temp.right;
                if(temp.right == null) {
                    al.add(node.val);
                    temp.right = node;
                    node = node.left;
                } else {
                    temp.right = null;
                    node = node.right;
                }
            }
        }
        return al;
    }
}