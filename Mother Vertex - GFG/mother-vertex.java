// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends




class Solution{
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj){
        boolean[]vis = new boolean[V];
        int mother = -1;
        for(int i=0; i<V; i++){
            if(vis[i] == false){
                vis[i] = true;
                mother = i;
                dfs(vis, adj, i);
            }
        }
        vis = new boolean[V];
        dfs(vis, adj, mother);
        vis[mother] = true;
        for(boolean bool:vis) if(!bool) return -1;
        
        return mother;
    }
    public void dfs(boolean[]vis, ArrayList<ArrayList<Integer>>adj, int i){
        for(int val:adj.get(i)){
            if(vis[val] == false) {
                vis[val] = true;
                dfs(vis, adj, val);
            }
        }
    }
}