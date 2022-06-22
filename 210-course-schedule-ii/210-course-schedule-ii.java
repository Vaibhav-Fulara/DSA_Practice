class Solution {
    public int[] findOrder(int num, int[][] pre) {
        int[]inDegree = new int[num];
        int[]order = new int[num];
        
        for(int[]arr:pre) inDegree[arr[0]]++;
        
        ArrayDeque<Integer>qu = new ArrayDeque<>();
        for(int i=0; i<num; i++){
            if(inDegree[i] == 0) {
                qu.add(i);
            }
        }
        
        int idx = 0;
        while(qu.size()!=0){
            int v = qu.poll();
            order[idx++] = v;
            
            for(int[]arr:pre){
                if(arr[1] == v){
                    inDegree[arr[0]]--;
                    if(inDegree[arr[0]] == 0) {
                        qu.add(arr[0]);
                    }
                }
            }
        }
        
        return idx == num? order:new int[0];
    }
}