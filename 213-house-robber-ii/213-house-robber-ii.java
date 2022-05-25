class Solution {
    public int rob(int[]arr) {
        int n = arr.length;
        if(n == 1) return arr[0];
        int one = getAns(arr,0,n-2);
        int two = getAns(arr, 1, n-1);
        return Math.max(one, two);
    }
    public int getAns(int[]arr, int lo, int hi){
        int dp1 = 0, dp2 = 0;
        for(int i=hi; i>=lo; i--){
            if(i == hi) {dp2 = arr[i]; continue;}
            if(i == hi-1) {dp1 = Math.max(arr[i], dp2); continue;}
            int pick = arr[i] + dp2;
            int notpick = dp1;
            dp2 = dp1;
            dp1 = Math.max(pick, notpick);
        }
        return dp1 == 0? dp2:dp1;
    }
}