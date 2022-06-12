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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode>qu = new LinkedList<>();
        root.val = 1;
        qu.add(root);
        qu.add(null);
        boolean bool = true;
        int max = 0, left = -1, right = -1;
        
        while(true){
            TreeNode node = qu.remove();
            
            if(node == null){
                max = Math.max(right - left + 1, max) ;
                left = right = -1;
                qu.add(null);
                if(qu.size() == 1) break;
            }
            
            else{
                if(node.left != null){
                    node.left.val = 2*node.val;
                    if(left == -1) left = right = node.left.val;
                    else right = node.left.val;
                    qu.add(node.left);
                }
                if(node.right != null){
                    node.right.val = 2*node.val + 1;
                    if(left == -1) left = right = node.right.val;
                    else right = node.right.val;
                    qu.add(node.right);
                }
            }
        }
        return max;
    }
}