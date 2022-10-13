/*
class LRUCache {
    LinkedHashMap<Integer, Integer>hm;
    int cap;
    public LRUCache(int capacity) {
        hm = new LinkedHashMap<>();
        cap = capacity;
    }
    
    public int get(int key) {
        if(hm.containsKey(key)) {int k = hm.remove(key); hm.put(key, k); return k;}
        return -1;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)) hm.remove(key);
        else if (hm.size()>cap-1){
            int oldest = hm.keySet().iterator().next();
            hm.remove(oldest);
        }
        hm.put(key, value);
    }
}
*/

class Node {
    int key;
    int val;
    Node next;
    Node prev;
}
class LRUCache {
    Map<Integer, Node>hm;
    Node head;
    Node tail;
    int cap;

    public void remove(Node root) {
        Node n1 = root.prev;
        Node n2 = root.next;
        n1.next = n2;
        n2.prev = n1;
    }

    public void addFirst(Node root) {
        Node node = head.next;
        head.next = root;
        root.prev = head;
        root.next = node;
        node.prev = root;
    }

    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        cap = capacity;
        hm = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(hm.containsKey(key) == false) {
            return -1;
        } else {
            Node node = hm.get(key);
            remove(node);
            addFirst(node);
            return node.val;
        }
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)) {
            Node node = hm.get(key);
            remove(node);
            addFirst(node);
            node.val = value;
        } else {
            if(hm.size() >= cap) {
                hm.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node node = new Node();
            node.key = key;
            node.val = value;
            addFirst(node);
            hm.put(key, node);
        }
    }
}