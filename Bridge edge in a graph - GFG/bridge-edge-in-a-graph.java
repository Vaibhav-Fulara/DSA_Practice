// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int c = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.isBridge(V,list,c,d));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d){
        time = 0; res = 0;
        
        boolean[]vis = new boolean[V];
        int[]discovery = new int[V];
        int[]lowest = new int[V];
        
        for(int i=0; i<V; i++){
            if(!vis[i]){
                traverse(adj, vis, discovery, lowest, c, d, i, -1);
            }
        }
        return res;
    }
    static int time;
    static int res;
    static void traverse(ArrayList<ArrayList<Integer>>adj, boolean[]vis, int[]discovery, int[]lowest, int c, int d, int u, int par){
        time++;
        discovery[u] = lowest[u] = time;
        
        vis[u] = true;
        for(int val:adj.get(u)){
            if(val == par) continue;
            else if(vis[val]){
                lowest[u] = Math.min(lowest[u], discovery[val]);
            } else {
                traverse(adj, vis, discovery, lowest, c, d, val, u);
                lowest[u] = Math.min(lowest[u], lowest[val]);
                
                if(lowest[val] > discovery[u]){
                    if((u == c && val == d) || (u == d && val == c)) res = 1;
                }
            }
        }
    }
}


