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
        Queue<TreeNode>og = new ArrayDeque<>();
        Queue<TreeNode>copy = new ArrayDeque<>();
        
        TreeNode root1 = original;
        TreeNode root2 = cloned;
        
        og.add(root1);
        copy.add(root2);
        
        while(og.size()!=0){
            TreeNode node1 = og.poll();
            TreeNode node2 = copy.poll();
            if(node1 == tar) return node2;
            if(node1.left != null){
                og.add(node1.left);
                copy.add(node2.left);
            }
            if(node1.right != null){
                og.add(node1.right);
                copy.add(node2.right);
            }
        }
        return null;
    }
}