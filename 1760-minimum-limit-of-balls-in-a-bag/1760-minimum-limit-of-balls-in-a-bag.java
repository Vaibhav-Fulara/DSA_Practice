class Solution {
    public int minimumSize(int[] nums, int k) {
        int min = 1;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) max = Math.max(max, nums[i]);
        while (min < max) {
            int mid = min + (max-min)/2;
            int ops = 0;
            for(int ball:nums) {
                if(ball > mid) {
                    int spare = ball - mid;
                    int temp = (spare + mid - 1) / mid;
                    ops += temp;
                }
            }
            if(ops > k) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return max;
    }
}