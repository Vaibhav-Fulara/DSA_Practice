class Solution {
    
    public boolean isBipartite(int[][] graph) {
        int[]arr = new int[graph.length];
        Arrays.fill(arr, -1);
        
        for(int t=0; t<graph.length; t++){
            if(arr[t] == -1){
                Queue<pair>qu = new LinkedList<>();
                qu.add(new pair(t,0));

                while(qu.size()!=0){
                    pair temp = qu.remove();
                    if(arr[temp.val] != -1){
                        if(arr[temp.val] == temp.col) continue;
                        else return false;
                    }

                    arr[temp.val] = temp.col;
                    int src = temp.val;

                    for(int val:graph[src]){
                        if(arr[val] == -1) qu.add (new pair(val, 1-temp.col));
                    }
                }
            }
        }
        return true;
    }
    
    public class pair{
        int val;
        int col;
        pair(){};
        pair(int val, int col){
            this.val = val;
            this.col = col;
        }
    }
}