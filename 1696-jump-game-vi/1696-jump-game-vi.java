// DP O(n*k) TLE
/*
class Solution {
    public int maxResult(int[] arr, int k) {
        Integer[]dp = new Integer[arr.length];
        return jump(arr, k, 0, dp);
    }
    public int jump(int[]arr, int k, int i, Integer[]dp){
        if(i == arr.length) return 0;
        
        if(dp[i] != null) return dp[i];
        
        int max = Integer.MIN_VALUE;
        for(int j = 1; j <= k; j++){
            if(i+j > arr.length) break;
            max = Math.max(max, jump(arr, k, i+j, dp));
        }
        return dp[i] = max + arr[i];
    }
}
*/

class Solution{
    public int maxResult(int[] nums, int k) {
        int n = nums.length, res = nums[0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.add(new int[] { nums[0], 0 });
        for(int i = 1; i < n; i++) {
            while(pq.peek()[1] < i - k) pq.poll();
            res = pq.peek()[0] + nums[i];
            pq.add(new int[] { res, i });
        }
        return res;
    }
}