/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>>al = new ArrayList<>();
        if(root==null) return al;
        
        Queue<Node>qu = new LinkedList<>();
        qu.add(root);
        qu.add(null);
        
        al.add(new ArrayList<>());
        int i=0;
        while(qu.size()!=0){
            if(qu.size()==1 && qu.peek()==null) break;
            Node temp = qu.remove();
            if(temp==null){
                al.add(new ArrayList<>());
                i++;
                qu.add(null);
            }
            else {
                al.get(i).add(temp.val);
                if(temp.children!=null) for(Node val:temp.children) qu.add(val);
            }
        }
        return al;
    }
}