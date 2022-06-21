// Recursion
// TLE + MME
/*
class Solution {
    public int furthestBuilding(int[] arr, int bricks, int ladders) {
        return jumpFurthest(arr, bricks, ladders, 0, dp);
    }
    public int jumpFurthest(int[]arr, int bricks, int ladders, int i){
        
        if(i == arr.length-1) return i;
        int h1 = arr[i], h2 = arr[i+1];
        
        if(h1 >= h2) {
            return jumpFurthest(arr, bricks, ladders, i+1, dp);
        } else{
            int diff = h2-h1;
            if(bricks >= diff) {
                if(ladders > 0){
                    return Math.max(jumpFurthest(arr, bricks, ladders-1, i+1),
                                    jumpFurthest(arr, bricks-diff, ladders, i+1));
                } else {
                    return jumpFurthest(arr, bricks-diff, ladders, i+1);
                } 
            } else if(ladders > 0) {
                return jumpFurthest(arr, bricks, ladders-1, i+1);
            } else return i;
        }
    }
}
*/

// Memoization
// MME
/*
class Solution {
    public int furthestBuilding(int[] arr, int bricks, int ladders) {
        int[][][]dp = new int[arr.length][bricks+1][ladders+1];
        for(int[][]ar:dp) for(int[]a:ar) Arrays.fill(a, -1);
        
        return jumpFurthest(arr, bricks, ladders, 0, dp);
    }
    public int jumpFurthest(int[]arr, int bricks, int ladders, int i, int[][][]dp){
        
        if(i == arr.length-1) return i;
        int h1 = arr[i], h2 = arr[i+1];
        
        if(dp[i][bricks][ladders] != -1) return dp[i][bricks][ladders];
        
        if(h1 >= h2) {
            return dp[i][bricks][ladders] = jumpFurthest(arr, bricks, ladders, i+1, dp);
        } else{
            int diff = h2-h1;
            if(bricks >= diff) {
                if(ladders > 0){
                    return dp[i][bricks][ladders] = Math.max(jumpFurthest(arr, bricks, ladders-1, i+1, dp), 
                                                             jumpFurthest(arr, bricks-diff, ladders, i+1, dp));
                } else {
                    return dp[i][bricks][ladders] = jumpFurthest(arr, bricks-diff, ladders, i+1, dp);
                } 
            } else if(ladders > 0) {
                return dp[i][bricks][ladders] = jumpFurthest(arr, bricks, ladders-1, i+1, dp);
            } else return dp[i][bricks][ladders] = i;
        }
    }
}
*/

// Priority Queue
class Solution{  
    public int furthestBuilding(int[] arr, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length - 1; i++) {
            int d = arr[i + 1] - arr[i];
            if (d > 0) pq.add(d);
            if (pq.size() > ladders) bricks -= pq.poll();
            if (bricks < 0) return i;
        }
        return arr.length - 1;
    }
}