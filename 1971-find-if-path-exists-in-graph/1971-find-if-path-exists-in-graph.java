class Solution {
    public boolean validPath(int n, int[][] edges, int src, int dest){
        List<Edge>[]graph = getGraph(n, edges);
        int[]arr = new int[n];
        return getPath(graph, src, dest, arr);
    }
    public boolean getPath(List<Edge>[]graph, int src, int dest, int[]arr){
        if(src == dest) return true;
        arr[src] = 1;
        for(int i = 0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            int nbr = e.nbr;
            if(arr[nbr] == 0){
                boolean bool = getPath(graph, nbr, dest, arr);
                if(bool) return true;
            }
        }
        return false;
    }
    
    public List<Edge>[] getGraph(int n, int[][]edges){
        List<Edge>[]graph = new ArrayList[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
        for(int[]edge:edges){
            int u = edge[0];
            int v = edge[1];
            graph[u].add(new Edge(u,v));
            graph[v].add(new Edge(v,u));
        }
        return graph;
    }
    public class Edge{
        int src;
        int nbr;
        Edge(){}
        Edge(int src, int nbr){
            this.src = src;
            this.nbr = nbr;
        }
    }
}