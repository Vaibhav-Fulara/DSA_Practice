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
// class Solution {
//     public int kthSmallest(TreeNode root, int k) {
//         Stack<Integer>st = new Stack<>();
//         addNodes(root,st);
//         while(k-- != 1) st.pop();
//         return st.peek();
//     }
//     public void addNodes(TreeNode root, Stack<Integer>st){
//         if(root==null) return;
//         addNodes(root.right, st);
//         st.add(root.val);
//         addNodes(root.left, st);
//     }
// }

// class Solution {
//     public int kthSmallest(TreeNode root, int k) {
//         Queue<Integer>qu = new LinkedList<>();
//         addNodes(root,qu,k);
//         while(qu.size()!=1) qu.remove();
//         return qu.remove();
//     }
//     public void addNodes(TreeNode root, Queue<Integer>qu, int k){
//         if(root==null) return;
//         if(qu.size()!=k) addNodes(root.left, qu, k);
//         if(qu.size()!=k) qu.add(root.val);
//         if(qu.size()!=k) addNodes(root.right, qu, k);
//     }
// }

class Solution{
    int iterator = 0, ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;
        
        kthSmallest(root.left,k);
        
        iterator++;
        if(k==iterator) ans=root.val;
        
        kthSmallest(root.right,k);
        
        return ans;
    }
}
