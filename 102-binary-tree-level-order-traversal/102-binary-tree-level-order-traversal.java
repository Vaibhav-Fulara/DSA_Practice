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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>list = new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode>qu = new LinkedList<>();
        qu.add(root);
        qu.add(null);
        list.add(new ArrayList<>());
        int i=0;
        while(qu.size()!=0){
            if(qu.size() == 1 && qu.peek() == null) break;
            TreeNode node = qu.remove();
            if(node==null){
                list.add(new ArrayList<>());
                i++;
                qu.add(null);
            }
            else{
                list.get(i).add(node.val);
                if(node.left != null) qu.add(node.left);
                if(node.right != null) qu.add(node.right);
            }
        }
        return list;
    }
}