// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}
// } Driver Code Ends

class Solution{
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer>st = new Stack<>();
        boolean[]vis = new boolean[V];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<V; i++){
            graph.add(new ArrayList<>());
            if(vis[i]) continue;
            dfs(vis, adj, i, st);
        }
        
        for(int i=0; i<adj.size(); i++){
            List<Integer>ls = adj.get(i);
            for(int j=0; j<ls.size(); j++){
                graph.get(ls.get(j)).add(i);
            }
        }
        
        boolean[] vi = new boolean[adj.size()];
        int ans = 0;
        
        while(st.size() != 0){
            int i = st.pop();
            if(vi[i] == false){
                ans++;
                vi[i] = true;
                dfsmod(vi, graph, i);
            }
        }
        
        return ans;
    }
    public void dfs(boolean[]vis, ArrayList<ArrayList<Integer>> adj, int i, Stack<Integer>st){
        for(int val:adj.get(i)){
            if(!vis[val]) {
                vis[val] = true;
                dfs(vis, adj, val, st);
            }
        }
        st.push(i);
    }
    
    public void dfsmod(boolean[]vis, ArrayList<ArrayList<Integer>> adj, int i){
        for(int val:adj.get(i)){
            if(!vis[val]) {
                vis[val] = true;
                dfsmod(vis, adj, val);
            }
        }
    }
}
