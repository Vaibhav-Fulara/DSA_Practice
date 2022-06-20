/* class Solution {
    public int minimumLengthEncoding(String[] words) {
        Trie trie = new Trie();
        for(String s:words) trie.add(s);
        
        int ans = 0;
        Node node = trie.getRoot();
        for(Node n:node.links){
            if(n != null) ans += traverse(node);
        }
        return ans;
    }
    
    public int traverse(Node node){
        int ans = 0;
        boolean bool = false;
        for(Node n:node.links){
            if(n != null) {
                ans += traverse(n);
                bool = true;
            }
        }
        
        if(!bool){
            System.out.println(node.height);
            ans += node.height+1;
        } 
        return ans;
    }
    
    public class Node{
        Node[]links = new Node[26];
        int height = 0;
        
        void add(char ch, Node node, int h){
            links[ch-'a'] = node;
            links[ch-'a'].height = h+1;
        }
        
        boolean containsKey(char ch) {return links[ch-'a'] != null;}
        Node get(char ch){return links[ch-'a'];}
    }
    
    public class Trie{
        Node root;
        public Trie(){
            root = new Node();
        }
        public Node getRoot(){return root;}
        public void add(String s){
            Node temp = root;
            for(int i=s.length()-1; i>=0; i--){
                char ch = s.charAt(i);
                if( ! temp.containsKey(ch)) temp.add(ch, new Node(), temp.height);
                temp = temp.get(ch);
            }
        }
    }
}
*/

class Solution {
    
    class TrieNode {
        TrieNode[] children;
        
        TrieNode() {
            this.children = new TrieNode[26];
        }
    }
    
    private boolean isAbsentThenAdd(String word, TrieNode node) {
        boolean isAbsent = false;
        for(int i = word.length()-1; i>=0; i--) {
            
            int charInt = word.charAt(i) - 'a';
            if(node.children[charInt] == null) {
                isAbsent = true;
                node.children[charInt] = new TrieNode();
            }
            node = node.children[charInt];
        }
                
         return isAbsent;      
    }
    
    public int minimumLengthEncoding(String[] words) {
           
        TrieNode root = new TrieNode();
        int sizeOfEncodedSTring = 0;
        
        Arrays.sort(words, (a, b) -> {
            if(a.length() > b.length()) return -1;
            else if(a.length() < b.length()) return 1;
            else return 0;
        });
        
        for(String word : words) {
            TrieNode currNode = root;
            if(isAbsentThenAdd(word, currNode)) {
                sizeOfEncodedSTring += word.length() + 1;
            }
        }
        
        return sizeOfEncodedSTring;
    }
}
