class Solution {
    public int rob(int[] arr) {
        int n = arr.length;
        int dp1 = 0, dp2 = 0;
        for(int i=n-1; i>=0; i--){
            if(i == n-1) {dp2 = arr[i]; continue;}
            if(i == n-2) {dp1 = Math.max(arr[i], dp2); continue;}
            int pick = arr[i] + dp2;
            int notpick = dp1;
            dp2 = dp1;
            dp1 = Math.max(pick, notpick);
        }
        return dp1 == 0? dp2:dp1;
    }
}