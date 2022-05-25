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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            if(root.val == targetSum) return 1;
            return 0;
        }
        Map<Integer, Integer>hm = new HashMap<>();
        hm.put(0,1);
        getSum(root, targetSum, hm, 0);
        return count;
    }
    public void getSum(TreeNode root, int tar, Map<Integer, Integer>hm, int curr){
        if(root == null) return;
        curr += root.val;
        if(hm.containsKey(curr-tar)) count += hm.get(curr-tar);
        hm.put(curr, hm.getOrDefault(curr, 0) + 1);
        getSum(root.left, tar, hm, curr);
        getSum(root.right, tar, hm, curr);
        hm.put(curr, hm.get(curr)-1);
    }
}