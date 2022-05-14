class Solution {
    public class Node{
        Node[]links = new Node[27];
        boolean flag;
        public Node(){}
        boolean containsKey(char ch){
            if(ch!='/') return links[ch-'a']!=null;
            return links[26]!=null;
        }
        Node get(char ch){
            if(ch!='/') return links[ch-'a'];
            return links[26];
        }
        void put(char ch, Node node){
            if(ch!='/')links[ch-'a'] = node;
            else links[26] = node;
        }
        void setEnd(){
            flag = true;
        }
        boolean isEnd(){
            return flag;
        }
    }
    
    public class Trie {
        private Node root;
        private Trie() { root = new Node(); }
        public boolean insert(String word) {
            Node node = root;
            for(int i=0; i<word.length(); i++){
                char ch = word.charAt(i);
                if(!node.containsKey(ch)) node.put(ch, new Node());
                node = node.get(ch);
                if(i==word.length()-1) break;
                if(word.charAt(i+1)=='/' && node.flag == true) return false;
            }
            node.setEnd();
            return true;
        }
        public boolean search(String word) {
            Node node = root;
            for(char ch:word.toCharArray()){
                if(!node.containsKey(ch)){
                    return false;
                }
                node = node.get(ch);
            }
            return node.isEnd();
        }
        public boolean startsWith(String prefix) {
            Node node = root;
            for(char ch:prefix.toCharArray()){
                if(!node.containsKey(ch)) return false;
                node = node.get(ch);
            }
            return true;
        }
    }
    
    public List<String> removeSubfolders(String[] folder) {
        Trie t = new Trie();
        Arrays.sort(folder);
        List<String>list = new ArrayList<String>();
        for(String fold:folder){
            if(t.insert(fold)) list.add(fold);
        }
        return list;
    }
}