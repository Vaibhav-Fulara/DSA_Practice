class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] pre, int[][] queries) {
        List<Boolean>ans = new ArrayList<>();
        List<List<Integer>>adj = new ArrayList<>();
        
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int i=0; i<pre.length; i++){
            int[]arr = pre[i];
            
            adj.get(arr[0]).add(arr[1]);
        }
         
        for(int i=0; i<queries.length; i++){
            int[]arr = queries[i];
            if(arr[0] == arr[1]) ans.add(true);
            ans.add(check(arr, adj));
        }
        
        return ans;
    }
    
    public boolean check(int[]arr, List<List<Integer>>adj){
        boolean[]vis = new boolean[adj.size()];
        ArrayDeque<Integer>qu = new ArrayDeque<>();
        
        qu.add(arr[0]);
        vis[arr[0]] = true;
        while(qu.size()!=0){
            int v = qu.poll();
            if(v == arr[1]) return true;
            for(int val:adj.get(v)){
                if(val == arr[1]) return true;
                if(vis[val] == false) {
                    vis[val] = true;
                    qu.add(val);
                }
            }
        }
        return false;
    }
}