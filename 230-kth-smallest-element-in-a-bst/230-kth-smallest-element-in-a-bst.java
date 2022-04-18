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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
        makePQ(root, pq, k);
        return pq.peek();
    }
    public void makePQ(TreeNode root, PriorityQueue<Integer>pq, int k){
        pq.add(root.val);
        if(root.left!=null) makePQ(root.left, pq, k);
        if(root.right!=null)makePQ(root.right, pq, k);
        while(pq.size()>k) pq.remove();
    }
}