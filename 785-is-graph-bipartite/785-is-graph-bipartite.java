class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<pair>qu = new LinkedList<>();
        int[]arr = new int[graph.length];
        Arrays.fill(arr, -1);
        for(int i=0; i<graph.length; i++){
            if(arr[i] == -1){
                qu.add(new pair(i, 0));
                while(qu.size()!=0){
                    pair temp = qu.remove();
                    for(int val:graph[temp.val]){
                        if(arr[val] == -1){
                            arr[val] = 1-temp.col;
                            qu.add(new pair(val, arr[val]));
                        }    
                        else{
                            if(arr[val] == 1-temp.col) continue;
                            else return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public class pair{
        int val;
        int col;
        pair(){}
        pair(int val,int col){
            this.val = val;
            this.col = col;
        }
    }
}