/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Queue<Node>qu = new LinkedList<>();
        qu.add(root);
        qu.add(null);
        Node nextNode = null;
        while(!(qu.size()==1 && qu.peek()==null)){
            Node node = qu.remove();
            if(node==null){
                nextNode = null;
                qu.add(null);
                continue;
            }
            node.next = nextNode;
            nextNode = node;
            if(node.right != null) qu.add(node.right);
            if(node.left != null) qu.add(node.left);
        }
        return root;
    }
}