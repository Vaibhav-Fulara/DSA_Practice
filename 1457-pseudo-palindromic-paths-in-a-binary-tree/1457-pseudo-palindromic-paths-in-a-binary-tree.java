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
    public int pseudoPalindromicPaths (TreeNode root) {
        int[]arr = new int[10];
        return getPalindrome(root, arr);
    }
    public int getPalindrome(TreeNode root, int[]arr){
        
        if(root == null) return 0;
        arr[root.val]++;
        
        int count = 0;
        if(root.left == null && root.right == null){
            if(check(arr)) count++;
        }
        
        count += getPalindrome(root.right, arr) + getPalindrome(root.left, arr);
        
        arr[root.val]--;
        return count;
    }
    public boolean check(int[]arr){
        int uni = 0;
        for(int val:arr) {
            if(val % 2 !=0) uni++;
            if(uni > 1) return false;
        }
        return true;
    }
}
