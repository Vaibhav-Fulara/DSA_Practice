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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>ans = new ArrayList<>();
        if(root == null) return ans;
        getPaths(ans, root, targetSum, new ArrayList<>());
        return ans;
    }
    public void getPaths(List<List<Integer>>ans, TreeNode node, int tar, List<Integer>al){
        if(node.left == null && node.right == null){
            al.add(node.val);
            if(tar == node.val) ans.add(new ArrayList<>(al));
            al.remove(al.size()-1);
            return;
        }
        tar -= node.val;
        al.add(node.val);
        if(node.left != null)  getPaths(ans, node.left, tar, al);
        if(node.right != null) getPaths(ans, node.right, tar, al);
        al.remove(al.size()-1);
    }
}