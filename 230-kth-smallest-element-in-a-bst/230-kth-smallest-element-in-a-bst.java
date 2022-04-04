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
    public int kthSmallest(TreeNode root, int k) {
        Stack<Integer>st = new Stack<>();
        addNodes(root,st);
        while(k-- != 1) st.pop();
        return st.peek();
    }
    public void addNodes(TreeNode root, Stack<Integer>st){
        if(root==null) return;
        addNodes(root.right, st);
        st.add(root.val);
        addNodes(root.left, st);
    }
}