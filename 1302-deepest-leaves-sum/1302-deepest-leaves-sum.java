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
    public int deepestLeavesSum(TreeNode root) {
        if(root==null) return 0;
        int sum = 0;
        Queue<TreeNode>qu = new LinkedList<>();
        qu.add(root);
        qu.add(null);
        while(!(qu.size()==1 && qu.peek()==null)){
            TreeNode temp = qu.remove();
            if(temp == null){
                sum = 0;
                qu.add(null);
            } 
            else{
                if(temp.left!=null) qu.add(temp.left);
                if(temp.right!=null) qu.add(temp.right);
                sum+=temp.val;
            }
        }
        return sum;
    }
}