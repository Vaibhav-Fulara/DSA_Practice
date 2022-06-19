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
    public int maxLevelSum(TreeNode root) {
        int minIdx = 0, idx = 1;
        long maxSum = (long)-1e5-1, curr = 0;
        Queue<TreeNode>qu = new LinkedList<>();
        qu.add(root);
        qu.add(null);
        while(!(qu.size() == 1 && qu.peek()==null)){
            TreeNode node = qu.poll();
            if(node == null){
                if(curr > maxSum){
                    maxSum = curr;
                    minIdx = idx;
                }
                idx++;
                curr = 0;
                qu.add(null);
            }
            else{
                curr += node.val;
                if(node.left != null) qu.add(node.left);
                if(node.right != null) qu.add(node.right);
            }
        }
        // System.out.println(curr + " " + idx + " " + maxSum);
        if(curr > maxSum) return idx;
        return minIdx;
    }
}