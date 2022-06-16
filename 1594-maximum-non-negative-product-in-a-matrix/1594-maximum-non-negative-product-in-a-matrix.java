class Solution {
    public int maxProductPath(int[][] arr) {
        
        pair[][]dp = new pair[arr.length][arr[0].length];
        
        for(int i=arr.length-1; i>=0; i--){
            for(int j=arr[0].length-1; j>=0; j--){
                if ( i == arr.length-1 && j == arr[0].length-1 ) {
                    dp[i][j] = new pair(arr[i][j], arr[i][j]);
                    continue;
                }

                pair ans = new pair();
                pair right = new pair(Integer.MAX_VALUE, Integer.MIN_VALUE), down = new pair(Integer.MAX_VALUE, Integer.MIN_VALUE);
                if(j < arr[0].length-1) right = dp[i][j+1];
                if(i < arr.length-1) down = dp[i+1][j];

                if(arr[i][j] >= 0){
                    ans.max = arr[i][j] * Math.max(right.max, down.max);
                    ans.min = arr[i][j] * Math.min(right.min, down.min);
                } else{
                    ans.max = arr[i][j] * Math.min(right.min, down.min);
                    ans.min = arr[i][j] * Math.max(right.max, down.max);
                }

                dp[i][j] = ans;
            }
        }
        
        pair p = dp[0][0];
        int val = (int)(p.max % (int)(1e9 + 7));
        return val >= 0? val : -1;
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