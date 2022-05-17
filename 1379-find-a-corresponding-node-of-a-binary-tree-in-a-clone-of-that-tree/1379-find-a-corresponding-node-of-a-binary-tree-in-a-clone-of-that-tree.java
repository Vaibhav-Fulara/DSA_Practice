/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode tar) {
        if(original == null || original == tar) return cloned;
        TreeNode left = getTargetCopy(original.left, cloned.left, tar);
        if(left!=null) return left;
        return getTargetCopy(original.right, cloned.right, tar);
    }
}