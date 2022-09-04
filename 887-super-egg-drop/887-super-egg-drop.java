class Solution {
    public int superEggDrop(int eggs, int floors) {
        if(eggs == 1) return floors;
        int[][]dp = new int[eggs+1][floors+1];
        for(int[]a:dp) Arrays.fill(a, -1);
        return solve(eggs, floors, dp);
    }
    public int solve(int eggs, int floors, int[][]dp) {
        if(floors == 0 || floors == 1 || eggs == 1) return floors;
        if(dp[eggs][floors] != -1) return dp[eggs][floors];
        int min = Integer.MAX_VALUE;
        int start = 0, end = floors;
        
        while(start <= end) {
            int k = start + (end-start)/2;
            
            int left = solve(eggs-1, k-1, dp);          // egg breaks
            int right = solve(eggs, floors-k, dp);      // egg stays
            int temp = 1 + Math.max(left, right);
            
            min = Math.min(min, temp);
            if(left < right) start = k+1;
            else end = k-1;
        }
        return dp[eggs][floors] = min;
    }
}