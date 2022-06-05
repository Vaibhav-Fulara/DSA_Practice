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
        if(root == null) return 0;
        Queue<TreeNode>qu = new LinkedList<>();
        root.val = 1;
        qu.add(root);
        qu.add(null);
        int left = -1, right = -1, max = 1;
        while(true){
            TreeNode temp = qu.remove();
            if(temp == null){
                max = Math.max(max, right-left+1);
                left = right = -1;
                qu.add(null);
                if(qu.size()==1) break;
                continue;
            }
            if(temp.left != null){
                temp.left.val = temp.val*2 - 1;
                if(left != -1) right = temp.left.val;
                else left = right = temp.left.val;
                qu.add(temp.left);
            }
            if(temp.right != null){
                temp.right.val = temp.val*2;
                if(left != -1) right = temp.right.val;
                else left = right = temp.right.val;
                qu.add(temp.right);
            }
        }
        return max;
    }
}