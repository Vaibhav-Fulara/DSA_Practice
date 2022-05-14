class Solution {
    public static class Node {
        Node[]links = new Node[26];
        boolean flag;
        public Node(){}
        boolean containsKey(char ch){
            return links[ch-'a']!=null;
        }
        Node get(char ch){
            return links[ch-'a'];
        }
        void put(char ch, Node node){
            links[ch-'a'] = node;
        }
        void setEnd(){
            flag = true;
        }
        boolean isEnd(){
            return flag;
        }
    }
    public static class Trie {
        private Node root;
        Trie() {
            root = new Node();
        }
  
        public void insert(String word) {
            Node node = root;
            for(char ch:word.toCharArray()){
                if(!node.containsKey(ch)){
                    node.put(ch, new Node());
                }
                node = node.get(ch);
            }
            node.setEnd();
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
                if(!node.containsKey(ch)){
                    return false;
                }
                node = node.get(ch);
            }
            return true;
        }
        
        public String replace(String str){
            Node node = root;
            String ans = "";
            for(int i=0; i<str.length(); i++){
                char ch = str.charAt(i);
                if(node.flag == true) return str.substring(0,i);
                if(!node.containsKey(ch)) return str;
                node = node.get(ch);
            }
            return str;
        }
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie t = new Trie();
        for(String str:dictionary) t.insert(str);
        String ans = "";
        String[]split = sentence.split(" ");
        for(String str:split){
            String word = t.replace(str);
            ans = ans + word + " ";
        }
        
        return ans.substring(0,ans.length()-1);
    }
}

