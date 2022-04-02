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
    public List<TreeNode> generateTrees(int n) {
        return getAns(1, n);
    }
    
    public List<TreeNode> getAns(int start, int end){
        List<TreeNode>ans = new ArrayList<>();
        if(start>end) {ans.add(null); return ans;}
        
        for(int i=start; i<=end; i++){
            List<TreeNode>left =  getAns(start,i-1);
            List<TreeNode>right = getAns(i+1,end);
            
            for(TreeNode lnode:left){
                for(TreeNode rnode:right){
                    TreeNode temp = new TreeNode(i);
                    temp.left = lnode;
                    temp.right = rnode;
                    ans.add(temp);
                }
            }
        }
        return ans;
    }
}