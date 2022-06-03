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
        Set<Integer>hs = new HashSet<>();
        return getPalindrome(root, hs);
    }
    public int getPalindrome(TreeNode root, Set<Integer>hs){
        
        if(root == null) return 0;
        
        if(hs.contains(root.val)) hs.remove(root.val);
        else hs.add(root.val);
        
        int count = 0;
        if(root.left == null && root.right == null) if(hs.size()<=1) count++;
        
        count += getPalindrome(root.right, hs) + getPalindrome(root.left, hs);
        
        if(hs.contains(root.val)) hs.remove(root.val);
        else hs.add(root.val);
        return count;
    }
}
