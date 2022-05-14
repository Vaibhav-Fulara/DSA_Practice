class Solution {
    public class Node{
        Node[]links = new Node[26];
        boolean flag = false;
        List<String>suggestions = new ArrayList<>();
        boolean containsKey(char ch){
            return links[ch-'a']!=null;
        }
        Node get(char ch){
            return links[ch-'a'];
        }
        void put(char ch, Node node){
            links[ch-'a'] = node;
        }
    }
    public class Trie{
        Node root;
        public Trie(){
            root = new Node();
        } 
        
        public void insert(String str){
            Node node = root;
            for(char ch:str.toCharArray()){
                if(!node.containsKey(ch)) node.put(ch, new Node());
                if(node.suggestions.size()<3) node.suggestions.add(str);
                node = node.get(ch);
            }
            node.suggestions.add(0, str);
            if(node.suggestions.size()>3) node.suggestions.remove(node.suggestions.size()-1);
        }
        
        public List<String> getStrings(String str){
            int k = 3;
            List<String>ans = new ArrayList<>();
            Node node = root;
            for(char ch:str.toCharArray()){
                if(!node.containsKey(ch)) return ans;
                node = node.get(ch);
            }
            return node.suggestions;
        }
    }
    
    public List<List<String>> suggestedProducts(String[] products, String str) {
        List<List<String>>al = new ArrayList<>();
        Arrays.sort(products);
        Trie t = new Trie();
        for(String s:products) t.insert(s);
        for(int i=1; i<=str.length(); i++){
            List<String>temp = t.getStrings(str.substring(0,i));
            al.add(temp);
        }
        return al;
    }
}