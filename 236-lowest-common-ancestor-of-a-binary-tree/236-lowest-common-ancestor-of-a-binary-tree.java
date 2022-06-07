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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> a1 = new ArrayList<>();
        List<TreeNode> a2 =  new ArrayList<>();
        
        getPath(root, p, a1);
        getPath(root, q, a2);
        
        TreeNode ans = root;
        int i = a1.size()-1, j = a2.size()-1;
        while(i >= 0 && j >= 0){
            if(a1.get(i) != a2.get(j)) break;
            ans = a1.get(i);
            i--; j--;
        }
        
        return ans;
    }
    public boolean getPath(TreeNode root, TreeNode p, List<TreeNode>al){
        if(root == null) return false;
        if(root == p){
            al.add(root);
            return true;
        }
        
        boolean left = getPath(root.left, p, al);
        boolean right = getPath(root.right, p, al);
        
        if(left || right) {
            al.add(root);
            return true;
        }
        
        return false;
    }
}