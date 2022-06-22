class Solution {
    public boolean canFinish(int num, int[][] pre) {
        if(pre.length == 0) return true;
        int[]inDegree = new int[num];
        
        List<List<Integer>>adj = new ArrayList<>();
        for(int i=0; i<num; i++) adj.add(new ArrayList<>());
        for(int[]arr:pre){
            adj.get(arr[0]).add(arr[1]);
        }
        
        for(int i=0; i<adj.size(); i++){
            List<Integer>al = adj.get(i);
            
            for(int val:al){
                inDegree[val]++;
            }
        }
        
        ArrayDeque<Integer>qu = new ArrayDeque<>();
        for(int v = 0; v<inDegree.length; v++){
            if(inDegree[v] == 0) {
                qu.add(v);
            }
        }
        
        int idx = 0;
        while(qu.size() > 0){
            idx++;
            int v = qu.remove();
            for(int n:adj.get(v)){
                inDegree[n]--;
                if(inDegree[n] == 0) qu.add(n);
            }
        }
        
        return idx==num;
    }
}