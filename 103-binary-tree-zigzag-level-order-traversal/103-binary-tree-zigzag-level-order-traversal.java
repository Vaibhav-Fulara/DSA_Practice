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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>ans = new ArrayList<>();
        getPath(root, ans, 0);
        for(int i=1; i<ans.size(); i+=2) Collections.reverse(ans.get(i));
        return ans;
    }

    public void getPath(TreeNode root, List<List<Integer>>ans, int lvl){
        if(root==null) return;
        if(lvl>=ans.size()) ans.add (new ArrayList<>());
        ans.get(lvl).add(root.val);
        getPath(root.left, ans, lvl+1);
        getPath(root.right, ans, lvl+1);
    }
}