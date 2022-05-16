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
    public int findBottomLeftValue(TreeNode root) {
        int val = root.val;
        
        Queue<TreeNode>qu = new LinkedList<>();
        qu.add(root);
        qu.add(null);
        
        while(!(qu.size()==1 && qu.peek()==null)){
            TreeNode temp = qu.poll();
            if(temp == null){
                if(!(qu.peek()==null)) val = qu.peek().val;
                qu.add(null);
                continue;
            }
            if(temp.left!=null) qu.add(temp.left);
            if(temp.right!=null) qu.add(temp.right);
        }
        
        return val;
    }
}
