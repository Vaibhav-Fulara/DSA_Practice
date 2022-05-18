class Solution {
    int[]disc, low;
    List<List<Integer>>ans;
    List<Integer>[]graph;
    int time = 1;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        // Prerequisites of Tarjan's algo
        disc = new int[n];
        low = new int[n];
        
        // Answer List
        ans = new ArrayList<>();
        
        // Graph Construction
        graph = new ArrayList[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
        for(List<Integer>list:connections) {
            graph[list.get(0)].add(list.get(1));
            graph[list.get(1)].add(list.get(0));
        }
        
        dfs(0,-1);
        return ans;
    }
    
    public void dfs(int curr, int prev){
        disc[curr] = low[curr] = time++;
        for (int nbr : graph[curr]){
            if(disc[nbr] == 0){
                dfs(nbr, curr);
                low[curr] = Math.min(low[nbr], low[curr]);
            }
            else if(nbr != prev) low[curr] = Math.min(low[curr], disc[nbr]);
            if (low[nbr] > disc[curr]) ans.add(Arrays.asList(curr, nbr));
        }
    }
}


// Tarjan's Algorithm