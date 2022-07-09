// DP 
// O(n*k) TLE
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

// Priority Queue
// O(n*log(k))
/*
class Solution{
    public int maxResult(int[] nums, int k) {
        int n = nums.length, res = nums[0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.add(new int[] { nums[0], 0 });
        for(int i = 1; i < n; i++) {
            while(pq.peek()[1] < i - k) pq.poll();
            res = pq.peek()[0] + nums[i];     // log(k) operation as opposed to earlier O(k) looping
            pq.add(new int[] { res, i });
        }
        return res;
    }
}
*/

// ArrayDeque 
// O(n)
class Solution{
    public int maxResult(int[] nums, int k) {
        Deque<Integer>deque = new ArrayDeque<>();
        deque.add(0);
        for(int i = 1; i < nums.length; i++) {
            nums[i] += nums[deque.peek()];
            if(i-k == deque.peek()) deque.poll();
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) deque.pollLast();
            deque.add(i);
        }
        return nums[nums.length - 1];
    }
}