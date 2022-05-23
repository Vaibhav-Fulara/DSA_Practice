/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node ans = new Node(-1);
        Node iter = ans;
        Node temp = head;
        HashMap<Node, Node>hm = new HashMap<>();
        while(temp!=null){
            if(hm.containsKey(temp)) iter.next = hm.get(temp);
            else {
                iter.next = new Node(temp.val);
                hm.put(temp, iter.next);
            }
            
            if(hm.containsKey(temp.random)) iter.next.random = hm.get(temp.random);
            else {
                if(temp.random == null) iter.next.random = null;
                else iter.next.random = new Node(temp.random.val);
                hm.put(temp.random, iter.next.random);
            }
            iter = iter.next;
            temp = temp.next;            
        }
        return ans.next;
    }
}