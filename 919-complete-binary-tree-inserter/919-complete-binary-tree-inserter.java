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
class CBTInserter {
    Queue<TreeNode>qu = new LinkedList<>();
    TreeNode init = null;
    public CBTInserter(TreeNode root) {
        init = root;
        qu.add(init);
    }
    
    public int insert(int val) {
        while(qu.size()!=0){
            TreeNode temp = qu.peek();
            if(temp.left == null){
                temp.left = new TreeNode(val);
                qu.add(temp.left);
                return temp.val;
            }
            else qu.add(temp.left);
            qu.remove();
            if(temp.right == null){
                temp.right = new TreeNode(val);
                qu.add(temp.right);
                return temp.val;
            }
            else qu.add(temp.right);
        }
        return init.val;
    }
    
    public TreeNode get_root() {
        return init;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */