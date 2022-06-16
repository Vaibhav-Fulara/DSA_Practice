class Solution {
    public int maxProductPath(int[][] grid) {
        
        pair[][]dp = new pair[grid.length][grid[0].length];
        
        pair p = traverse(grid, 0, 0, dp);
        int val = (int)(p.max % (int)(1e9 + 7));
        return val >= 0? val : -1;
    }
    public pair traverse(int[][]arr, int i, int j, pair[][]dp){
        if ( i == arr.length-1 && j == arr[0].length-1 ) return dp[i][j] = new pair(arr[i][j], arr[i][j]);
        
        if(dp[i][j] != null) return dp[i][j];
        
        pair ans = new pair();
        pair right = new pair(Integer.MAX_VALUE, Integer.MIN_VALUE), down = new pair(Integer.MAX_VALUE, Integer.MIN_VALUE);
        if(j < arr[0].length-1) right = traverse(arr, i, j+1, dp);
        if(i < arr.length-1) down = traverse(arr, i+1, j, dp);
        
        if(arr[i][j] >= 0){
            ans.max = arr[i][j] * Math.max(right.max, down.max);
            ans.min = arr[i][j] * Math.min(right.min, down.min);
        } else{
            ans.max = arr[i][j] * Math.min(right.min, down.min);
            ans.min = arr[i][j] * Math.max(right.max, down.max);
        }
        
        return dp[i][j] = ans;
    }
    public class pair{
        long min;
        long max;
        pair(){}
        pair(long min, long max){
            this.min = min;
            this.max = max;
        }
    }
}