class Solution {
    public int longestCycle(int[]arr) {
        int max = -1;
        boolean[]vis = new boolean[arr.length];
        for(int i=0; i<arr.length; i++) {
            
            if(vis[i]) continue;
            Map<Integer, Integer>hm = new HashMap<>();
            
            int temp = i;
            int counter = 0;
            while(arr[temp] != -1) {
                if(hm.containsKey(temp)) {
                    max = Math.max(max, counter - hm.get(temp));
                    break;
                }
                if(vis[temp]) break;
                vis[temp] = true;
                hm.put(temp, counter++);
                temp = arr[temp];
            }
        }
        return max == 0? -1:max;
    }
}

/*
[-1,4,-1,2,0,4]
WA 0
AC -1

[49,29,24,24,-1,-1,-1,2,23,-1,44,47,52,49,9,31,40,34,-1,53,33,-1,2,-1,18,31,0,9,47,35,-1,-1,-1,-1,4,12,14,19,-1,4,4,43,25,11,54,-1,25,39,17,-1,22,44,-1,44,29,50,-1,-1]
WA 2
AC -1
*/

/*
public int longestCycle(int[] edges) {
    int res = -1;
    boolean[] vis = new boolean[edges.length]; // global visisted

    for(int i=0; i<edges.length; i++){
        if(vis[i]) continue;
        HashMap<Integer, Integer> x = new HashMap<>();  // local visited
        for (int idx=i, dist=0; idx!=-1; idx=edges[idx]){
            if(x.containsKey(idx)){
                res = Math.max(res, dist-x.get(idx));
                break;
            }
            if(vis[idx]) break;
            vis[idx] = true;
            x.put(idx, dist++);
        } 
    }
    return res;
}
*/