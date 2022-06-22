class Solution {
    public boolean canFinish(int num, int[][] pre) {
        if(pre.length == 0) return true;
        int[]inDegree = new int[num];
        
        for(int[]arr:pre){
            inDegree[arr[0]]++;
        }
        
        ArrayDeque<Integer>qu = new ArrayDeque<>();
        for(int i=0; i<num; i++){
            if(inDegree[i] == 0) qu.add(i);
        }
        
        int i=0;
        while(!qu.isEmpty()){
            int val = qu.poll();
            i++;
            for(int[]arr:pre){
                if(arr[1] == val){
                    inDegree[arr[0]]--;
                    if(inDegree[arr[0]] == 0) qu.add(arr[0]);
                }
            }
        }
        
        return i==num;
    }
}