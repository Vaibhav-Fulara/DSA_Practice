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
        List<List<Integer>>al = new ArrayList<>();
        if(root == null) return al;
        solve(root, al, new ArrayList<>(), targetSum);
        return al;
    }
    public void solve(TreeNode root, List<List<Integer>>al, List<Integer>a, int sum) {
        a.add(root.val);
        sum -= root.val;
        if(sum == 0 && root.left == null && root.right == null) al.add(new ArrayList<>(a));
        if(root.left != null) solve(root.left, al, a, sum);
        if(root.right != null) solve(root.right, al, a, sum);
        a.remove(a.size()-1);
    }
}