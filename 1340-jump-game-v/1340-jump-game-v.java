class Solution {
    public int maxJumps(int[] arr, int d) {
        int max = Integer.MIN_VALUE;
        int[]dp = new int[arr.length];
        Arrays.fill(dp, -1);
        
        for(int i=0; i<arr.length; i++) max = Math.max(getMaxJumps(arr, d, dp, i), max);
        
        return max;
        
    }
    public int getMaxJumps(int[]arr, int d, int[]dp, int i){
        if(dp[i] != -1) return dp[i];
        int max = 1, j = i-1, val = arr[i];
        
        while(j >= 0 && val > arr[j] && i-j <= d){
            // System.out.println(i+ " " +j);
            max = Math.max( 1 + getMaxJumps(arr, d, dp, j), max);
            j--;
        }
        
        j = i+1;
        
        while(j <= arr.length-1 && val > arr[j] && j-i <= d){
            // System.out.println(i+ " " +j);
            max = Math.max( 1 + getMaxJumps(arr, d, dp, j), max);
            j++;
        }

        return dp[i] = max;
    }
}