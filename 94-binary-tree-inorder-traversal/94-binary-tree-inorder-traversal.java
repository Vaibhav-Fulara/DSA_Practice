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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>al = new ArrayList<>();
        getPath(root, al);
        return al;
    }
    public void getPath (TreeNode root, List<Integer>al){
        if(root == null) return;
        getPath(root.left, al);
        al.add(root.val);
        getPath(root.right, al);
    }
}