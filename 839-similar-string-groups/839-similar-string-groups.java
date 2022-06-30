class Solution {
    public int numSimilarGroups(String[] strs) {
        parent = new int[strs.length];
        ranks = new int[strs.length];
        
        for(int i=0; i<parent.length; i++) parent[i] = i;
        
        for(int i=0; i<strs.length; i++){
            for(int j=i+1; j<strs.length; j++){
                if(isUnion(strs[i], strs[j]) == false) continue;
                int l1 = find(i);
                int l2 = find(j);
                if(l1 != l2) union(l1, l2);
            }
        }
        
        int ans = 0;
        for(int i=0; i<parent.length; i++){
            if(parent[i] == i) ans++;
        }
        return ans;
    }
    
    int[]parent;
    int[]ranks;
    
    public boolean isUnion(String s1, String s2){
        int i=0, j=0;
        int strike = 0;
        while(i!=s1.length()){
            if(s1.charAt(i) != s2.charAt(j)) strike++;
            i++; j++;
        }
        return strike <= 2;
    }
    
    public int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    
    public void union(int i, int j){
        if(ranks[i] > ranks[j]){
            parent[j] = i;
        } else if(ranks[j] > ranks[i]){
            parent[i] = j;
        } else {
            parent[j] = i;
            ranks[i]++;
        }
    }
}