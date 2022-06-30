// { Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
    
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
	    Complete obj = new Complete();
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int N = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    int arr [][] = new int[K][2];
		    for(int i = 0;i<K;i++){
	            line = br.readLine();
		        String[] elements = line.trim().split("\\s+");
		        arr[i][0] = Integer.parseInt(elements[0]);
		        arr[i][1] = Integer.parseInt(elements[1]);    
	        }
            int ans = obj.doctorStrange(N, K, arr);
            System.out.println(ans);
    	    
		}
	}
}



// } Driver Code Ends


//User function Template for Java

//User function Template for Java


class Complete{
    
    public static int doctorStrange (int n, int k, int g[][]) {
        n++;       
        List<List<Integer>>adj = new ArrayList<>();
        for(int t=0; t<n; t++) adj.add(new ArrayList<>());
        
        for(int i=0; i<k; i++){
            int[]ls = g[i];
            int u = ls[0], v = ls[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        // for(List<Integer>ls:adj) System.out.println(ls);
        
        Set<Integer>hs = new HashSet<>();
        boolean[]vis = new boolean[n];
        int[]discovery = new int[n];
        int[]lowest = new int[n];
        
        for(int i=1; i<n; i++){
            if(vis[i] == false){
                vis[i] = true;
                dfs (adj, vis, discovery, lowest, i, -1, hs);
            }
        }
        
        return hs.size();
    }
    
    static int time = 0;
    public static void dfs(List<List<Integer>>adj, boolean[]vis, int[]discovery, int[]lowest, int u, int par, Set<Integer>hs){
        time++;
        discovery[u] = time;
        lowest[u] = time;
        int c=0;
        for(int v:adj.get(u)){
            if(v == par) continue;
            else if(vis[v]){
                lowest[u] = Math.min(lowest[u], discovery[v]);
            } else {
                c++;
                vis[v] = true;
                dfs(adj, vis, discovery, lowest, v, u, hs);
                lowest[u] = Math.min(lowest[u], lowest[v]);
                if(par != -1 && lowest[v] >= discovery[u]){
                    hs.add(u);
                }
            }
        }
        if(par == -1 && c>1) hs.add(u);
    }
}