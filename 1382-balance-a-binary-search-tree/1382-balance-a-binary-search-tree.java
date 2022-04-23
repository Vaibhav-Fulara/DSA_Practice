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
    
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode>al = new ArrayList<>();
        iterate(root, al);
        int n = al.size();
        if(n==1) return root;
        return get(al, 0, n-1);
    }
    
    public void iterate(TreeNode root, List<TreeNode>al){
        if(root == null) return;
        iterate(root.left, al);
        al.add(root);
        iterate(root.right, al);
    }
    
    public TreeNode get(List<TreeNode>al, int low, int hi){
        if(low>hi) return null;
        int mid = (low+hi)/2;
        TreeNode parent = new TreeNode(al.get(mid).val);
        parent.left = get(al, low, mid-1);
        parent.right = get(al, mid+1, hi);
        return parent;
    }
}