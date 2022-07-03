/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Node head = new Node();
        Map<Integer, Node>hm = new HashMap<>();
        clone(head, node, hm);
        return head;
    }
    public void clone(Node head, Node node, Map<Integer, Node>hm){
        head.val = node.val;
        hm.put(node.val, head);
        
        for(int i=0; i<node.neighbors.size(); i++){
            Node temp = node.neighbors.get(i);
            if(!hm.containsKey(temp.val)) {
                head.neighbors.add(new Node());
                clone(head.neighbors.get(i), temp, hm);
            }
            else{
                head.neighbors.add(hm.get(temp.val));
            }
        }
    }
}