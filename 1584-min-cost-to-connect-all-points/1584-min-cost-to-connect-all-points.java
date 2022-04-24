// class Solution {
//     public static class Edge{
//         int src;
//         int nbr;
//         int wt;
//         Edge(int src, int wt){
//             this.src = src;
//             this.wt = wt;
//         }
//         Edge(int src, int nbr, int wt){
//             this.src = src;
//             this.nbr = nbr;
//             this.wt = wt;
//         }
//     }
//     public static void addToGraph(List<Edge>[]graph, int src, int dest, int wt){
//         graph[src].add(new Edge(src, dest, wt));
//         graph[dest].add(new Edge(dest, src, wt));
//     }
   
//     public int minCostConnectPoints(int[][]arr) {
//         int n = arr.length;
//         List<Edge>[]graph = new ArrayList[n];
//         for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
//         for(int i=0; i<arr.length-1; i++){
//             for(int j=i+1; j<arr.length; j++){
//                 int src = i;
//                 int dest = j;
//                 int wt = Math.abs(arr[i][0]-arr[j][0]) + Math.abs(arr[i][1]-arr[j][1]);
//                 addToGraph(graph, src, dest, wt);
//             }
//         }
//         return (primsAlgo(graph));
//     }
    
//     public static int primsAlgo(List<Edge>[]graph){
//         int minCost = 0;
//         int[]arr = new int[graph.length];
//         Arrays.fill(arr,-1);
//         PriorityQueue<Edge>pq = new PriorityQueue<>((a,b)->{return a.wt-b.wt;});
//         pq.add(new Edge(0,0));
//         while(pq.size()!=0){
//             Edge temp = pq.remove();
//             if(arr[temp.src]==-1) minCost += temp.wt;
//             arr[temp.src] = 0;
//             for(Edge e:graph[temp.src]){
//                 int nbr = e.nbr;
//                 int cost = e.wt;
//                 if(arr[nbr]==-1) pq.add(new Edge(nbr, cost));
//             }
//         }
//         return minCost;
//     }
// }


class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int [] {0, 0, 0});
        
        boolean [] visited = new boolean [n];
        int cost = 0;
        int edges = 0;
        
        while (!pq.isEmpty() || edges < n - 1) {
            int [] current = pq.remove();
            if (visited[current[1]]) continue;
            visited[current[1]] = true;
            cost += current[2];
            edges += 1;
            for (int j = 0; j< n; j++) if (!visited[j]) {
                pq.add(new int [] {current[1], j, Math.abs(points[current[1]][0] - points[j][0]) + Math.abs(points[current[1]][1] - points[j][1])});
            }
        }
        return cost;
    }
}