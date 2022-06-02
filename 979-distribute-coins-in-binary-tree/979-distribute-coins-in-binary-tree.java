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
    int moves = 0;
    public int distributeCoins(TreeNode root) {
        getMinMoves(root);
        return moves;
    }
    
    public pair getMinMoves(TreeNode root){
        if(root == null) return new pair(0,0);
        pair left = getMinMoves(root.left);
        pair right = getMinMoves(root.right);
        
        pair curr = new pair(left.nodes + right.nodes + 1, left.coins + right.coins + root.val);
        moves += Math.abs(curr.coins - curr.nodes);
        return curr;
    }
}
class pair{
    int nodes;
    int coins;
    pair(){}
    pair(int nodes, int coins){
        this.nodes = nodes;
        this.coins = coins;
    }
}