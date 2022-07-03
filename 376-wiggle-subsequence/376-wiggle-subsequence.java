class Solution {
    public int wiggleMaxLength(int[]arr) {
        int[][]dp = new int[arr.length][3];
        for(int[]ar:dp) Arrays.fill(ar, -1);
        return getWiggle(arr, dp, 0, 0);
    }
    public int getWiggle(int[]arr, int[][]dp, int i, int wig){
        if(i == arr.length) return 0;
        if(dp[i][wig+1] != -1) return dp[i][wig+1];
        
        int inc = -1001;
        if(i == 0 || (wig == -1 && arr[i] > arr[i-1]) || (wig == 1 && arr[i] < arr[i-1])){
            if(wig == 0) inc = 1 + Math.max(getWiggle(arr, dp, i+1, 1), getWiggle(arr, dp, i+1, -1));
            else inc = 1 + getWiggle(arr, dp, i+1, -wig);
        }
        int ign = getWiggle(arr, dp, i+1, wig);
        return dp[i][wig+1] = Math.max(inc, ign);
    }
}