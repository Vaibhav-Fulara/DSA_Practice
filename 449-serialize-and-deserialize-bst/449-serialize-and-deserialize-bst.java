/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return ".";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val + " ");
        sb.append(serialize(root.left) + " ");
        sb.append(serialize(root.right));
        // System.out.println(sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String str) {
        if(str.charAt(0) == '.') return null;
        
        Stack<pair>st = new Stack<>();
        String[]arr = str.split(" ");
        
        TreeNode root = new TreeNode (Integer.parseInt(arr[0]));
        st.add(new pair(root, 0));
        
        int i=1;
        
        while(st.size() != 0){
            
            String s = arr[i];
            pair p = st.pop();
            
            if(p.state == 0){
                if(s.equals("."))  st.add(new pair(p.node, 1));
                else {
                    p.node.left = new TreeNode(Integer.parseInt(s));
                    st.add(new pair(p.node, 1));
                    st.add(new pair(p.node.left, 0));
                }
            }
            
            else if(p.state == 1){
                if(! s.equals(".")){
                    p.node.right = new TreeNode(Integer.parseInt(s));
                    st.add(new pair(p.node.right, 0));
                }
            }
            
            else continue;
            
            i++;
        }
        
        return root;
    }
    
    public class pair{
        TreeNode node;
        int state;
        pair(TreeNode node, int state){
            this.node = node;
            this.state = state;
        }
    }
}


        


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;