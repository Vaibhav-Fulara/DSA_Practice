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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>>al = new ArrayList<>();
        if(root == null) return al;
        Stack<List<Integer>>st = new Stack();
        List<Integer>curr = new ArrayList<>();
        Queue<TreeNode>qu = new LinkedList<>();
        
        qu.add(root);
        qu.add(null);
        
        while(!(qu.size() == 1 && qu.peek()==null)){
            TreeNode temp = qu.poll();
            if(temp == null){
                qu.add(null);
                st.add(curr);
                curr = new ArrayList<>();
                continue;
            }
            curr.add(temp.val);
            if(temp.left!=null) qu.add(temp.left);
            if(temp.right!=null) qu.add(temp.right);
        }
        al.add(curr);
        
        while(!st.isEmpty()){
            al.add(st.pop());
        }
        return al;
    }
}