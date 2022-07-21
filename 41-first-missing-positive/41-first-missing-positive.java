class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++) if(nums[i] <= 0) nums[i] = n+1;
        for(int num:nums) {
            if(Math.abs(num) <= n) nums[Math.abs(num)-1] = -Math.abs(nums[Math.abs(num)-1]);
        }
        for(int i=0; i<n; i++) if(nums[i] > 0) return i+1;
        return n+1;
    }
}