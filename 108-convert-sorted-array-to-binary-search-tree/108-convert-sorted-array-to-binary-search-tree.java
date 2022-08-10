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
    public TreeNode sortedArrayToBST(int[]arr) {
        return solve(arr, 0, arr.length-1);
    }
    public TreeNode solve(int[]arr, int l, int r) {
        if(l > r) return null;
        if(l == r) return new TreeNode(arr[l]);
        int mid = l + (r-l)/2;
        TreeNode head = new TreeNode(arr[mid]);
        head.left = solve(arr, l, mid-1);
        head.right = solve(arr, mid+1, r);
        return head;
    }
}