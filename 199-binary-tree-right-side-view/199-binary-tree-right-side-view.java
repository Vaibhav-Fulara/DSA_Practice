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
    public List<Integer> rightSideView(TreeNode node) {
        if(node==null) return new ArrayList<>();
        List<Integer>al = new ArrayList<>();
        Queue<TreeNode>qu = new LinkedList<>();
        qu.add(node);
        al.add(node.val);
        TreeNode prev = node;
        while(qu.size()!=0){
            int size = qu.size();
            while(size-- >0){
                TreeNode rem = qu.remove();
                if(rem.left!=null) {qu.add(rem.left); prev = rem.left;}
                if(rem.right!=null) {qu.add(rem.right); prev = rem.right;}
            }
            al.add(prev.val);
        }
        al.remove(al.size()-1);
        return al;
    }
}