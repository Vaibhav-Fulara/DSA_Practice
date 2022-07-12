class Solution {
    public int findCircleNum(int[][] arr) {
        int n = arr.length;
        
        parent = new int[n];
        ranks = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i != j && arr[i][j] == 1){
                    union(i,j);
                }
            }
        }
        
        int count = 0;
        for(int i=0; i<arr.length; i++) if(parent[i] == i) count ++;
        return count;
    }
    
    int[]parent;
    int[]ranks;
    
    public int find(int x) {
        if(parent[x] == x) return parent[x];
        int val = find(parent[x]);
        return parent[x] = val;
    }
    
    public void union(int s1, int s2){
        int l1 = find(s1);
        int l2 = find(s2);
        if(l1 == l2) return;
        if(ranks[l1] > ranks[l2]) {
            parent[l2] = l1;
        } else if(ranks[l2] > ranks[l1]) {
            parent[l1] = l2;
        } else {
            parent[l2] = l1;
            ranks[l1]++;
        }
    }
}