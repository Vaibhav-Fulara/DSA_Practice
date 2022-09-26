// Sorting

/*
class Solution {
    public boolean equationsPossible(String[]arr) {
        int[]parent = new int[26];
        int[]ranks = new int[26];
        
        Arrays.sort(arr, (a,b)->{
            if(a.charAt(1) == '!' && b.charAt(1) == '=') return 1;
            else return -1;
        });
        
        for(int i=0; i<parent.length; i++) parent[i] = i;
        
        for(String s:arr){
            char ch1 = s.charAt(0);
            char sign = s.charAt(1);
            char ch2 = s.charAt(3);
            
            int s1l = find(ch1-'a', parent);
            int s2l = find(ch2-'a', parent);
            if(s1l != s2l && sign == '=') union(s1l, s2l, parent, ranks);
            if(s1l == s2l && sign == '!') return false;
        }
        
        return true;
    }
    
    public int find(int x, int[]parent){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x], parent);
    }
    
    public void union(int a, int b, int[]parent, int[]ranks){
        if(ranks[a] > ranks[b]) parent[b] = a;
        else if(ranks[b] > ranks[a]) parent[a] = b;
        else{
            parent[a] = b;
            ranks[b]++;
        }
    }
}
*/


// Dual Traversal
class Solution {
    public boolean equationsPossible(String[]arr) {
        int[]parent = new int[26];
        int[]ranks = new int[26];

        for(int i=0; i<parent.length; i++) parent[i] = i;
        
        for(String s:arr){
            char ch1 = s.charAt(0);
            char sign = s.charAt(1);
            char ch2 = s.charAt(3);
            
            if(sign == '='){
                int s1l = find(ch1-'a', parent);
                int s2l = find(ch2-'a', parent);
                if(s1l != s2l) union(s1l, s2l, parent, ranks);
            }
        }
        
        for(String s:arr){
            char ch1 = s.charAt(0);
            char sign = s.charAt(1);
            char ch2 = s.charAt(3);
            
            if(sign == '!'){
                int s1l = find(ch1-'a', parent);
                int s2l = find(ch2-'a', parent);
                if(s1l == s2l) return false;
            }
        }
        
        return true;
    }
    
    public int find(int x, int[]parent){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x], parent);
    }
    
    public void union(int a, int b, int[]parent, int[]ranks){
        if(ranks[a] > ranks[b]) parent[b] = a;
        else if(ranks[b] > ranks[a]) parent[a] = b;
        else{
            parent[a] = b;
            ranks[b]++;
        }
    }
}