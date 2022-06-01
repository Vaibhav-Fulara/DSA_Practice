class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {       
        
        ArrayList<Integer>[]graph = new ArrayList[n];               // graph made of integer as their are no wts and dests
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();  // assigning a hashset to each graph inde (could have done with al)
        
        for(int[]edge:edges){
            int src = edge[0], dest = edge[1];
            graph[src].add(dest);
            graph[dest].add(src);
        }
        
        int[]nodes = new int[n];        // nodes array to store the no of nodes below the current node
        int[]res = new int[n];          // res array to store number of links below current node
        
        populate(graph, nodes, res, 0, -1);     // completing the nodes and result array, initially only 0 position of res is correct
        generateResult(graph, nodes, res, 0, -1);
        
        return res;
    }
    
    public void generateResult(List<Integer>[]graph, int[]nodes, int[]res, int src, int par){
        for(int nbr:graph[src]){
            if(nbr != par){
                res[nbr] = res[src] + nodes.length - nodes[nbr] - nodes[nbr];
                generateResult(graph, nodes, res, nbr, src);
            }
        }
    }
    
    public void populate(List<Integer>[]graph, int[]nodes, int[]res, int src, int par){
        for(int nbr:graph[src]){                        // we dont return as in the end, the leaf node has only one nbr: the parent
            if(nbr != par){                             // making sure that the node doesn't takes into account the parent node
                populate(graph, nodes, res, nbr, src);  // recursive post order traversal
                nodes[src] += nodes[nbr];               // the no. of neighbours of children nodes must be added to the parent node (see diagram)
                res[src] += nodes[nbr] + res[nbr];      // the no. of neighbours and edges linked to children nodes must be added to the parent node 
                                                        // (see diagram)
            }
        }
        
        nodes[src]++;
    }
}