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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int n = pre.length;
        Map<Integer, Integer>hm = new HashMap<>();
        for(int i=0; i<n; i++) hm.put(post[i], i);
        return getTree(hm, pre, 0, n-1, 0, n-1);
    }
    public TreeNode getTree(Map<Integer, Integer>hm, int[]pre, int prel, int prer, int postl, int postr){
        if(prel > prer) return null;
        
        TreeNode node = new TreeNode(pre[prel]);
        if(prel == prer) return node;
        
        int lhs = hm.get(pre[prel + 1]);
        int count = lhs - postl;
        
        node.left = getTree(hm, pre, prel+1, prel + count +1, postl, lhs);
        node.right = getTree(hm, pre, prel + count +2, prer, lhs+1, postr-1);
        return node;
    }
}