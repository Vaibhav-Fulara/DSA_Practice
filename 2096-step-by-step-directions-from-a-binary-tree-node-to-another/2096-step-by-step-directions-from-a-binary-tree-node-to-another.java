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
    public String getDirections(TreeNode root, int strt, int dest) {
        
        List<Character> al1 = new ArrayList<>(), al2 = new ArrayList<>();
        
        getLca(root, strt, al1);
        getLca(root, dest, al2);
        
        int n1 = al1.size()-1, n2 = al2.size()-1, i=0;
        
        while(n1>=0 && n2>=0 && al1.get(n1) == al2.get(n2)){
            i++; n1--; n2--;
        }
        
        StringBuilder ans = new StringBuilder();
        i = al1.size() - i;
        
        while(i!=0) {
            ans.append('U');
            i--;
        }
        
        for(int idx = n2; idx>=0; idx--) ans.append(al2.get(idx));
        return ans.toString();
    }
    public boolean getLca(TreeNode root, int val, List<Character>al){
        if(root == null) return false;
        if(root.val == val) return true;
        if(getLca(root.left, val, al)) {al.add('L'); return true;}
        if(getLca(root.right, val, al)) {al.add('R'); return true;}
        return false;
    }
}