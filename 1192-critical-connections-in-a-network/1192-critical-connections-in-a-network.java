class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        List<List<Integer>>adj = new ArrayList<>();
        for(int t=0; t<n; t++) adj.add(new ArrayList<>());
        
        for(int i=0; i<connections.size(); i++){
            List<Integer>ls = connections.get(i);
            int u = ls.get(0), v = ls.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        // for(List<Integer>ls:adj) System.out.println(ls);
        
        List<List<Integer>>ans = new ArrayList<>();
        Set<pair>hs = new HashSet<>();
        boolean[]vis = new boolean[n];
        int[]discovery = new int[n];
        int[]lowest = new int[n];
        
        for(int i=0; i<n; i++){
            if(vis[i] == false){
                vis[i] = true;
                dfs (adj, vis, discovery, lowest, i, -1, hs);
            }
        }
        
        for(pair p:hs){
            List<Integer>ls = new ArrayList<>();
            ls.add(p.x);
            ls.add(p.y);
            ans.add(new ArrayList<>(ls));
        }
        
        return ans;
    }
    
    int time = 0;
    public void dfs(List<List<Integer>>adj, boolean[]vis, int[]discovery, int[]lowest, int u, int par, Set<pair>hs){
        time++;
        discovery[u] = time;
        lowest[u] = time;
        for(int v:adj.get(u)){
            if(v == par) continue;
            else if(vis[v]){
                lowest[u] = Math.min(lowest[u], discovery[v]);
            } else {
                vis[v] = true;
                dfs(adj, vis, discovery, lowest, v, u, hs);
                lowest[u] = Math.min(lowest[u], lowest[v]);
                if(lowest[v] > discovery[u]){
                    hs.add(new pair(u,v));
                }
            }
        }
    }
    
    public class pair{
        int x;
        int y;
        pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}