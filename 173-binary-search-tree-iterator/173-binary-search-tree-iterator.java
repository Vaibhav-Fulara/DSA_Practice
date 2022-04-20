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
class BSTIterator {
    Stack<TreeNode>st = new Stack<>();
    public BSTIterator(TreeNode root) {
        createStack(root);
    }
    
    public void createStack(TreeNode root){
        if(root.right != null) createStack(root.right);
        st.push(root);
        if(root.left != null) createStack(root.left);
    }
    
    public int next() {
        return st.pop().val;
    }
    
    public boolean hasNext() {
        if(st.size()>=1) return true;
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */