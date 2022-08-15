class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0;
        int hi = nums[nums.length - 1] - nums[0];
        
        while(lo < hi) {
            
            int mid = lo + (hi - lo)/2;
            
            int j = 0;
            int count = 0;
            
            for(int i = 0; i < nums.length; i++){
                while(j < nums.length && nums[i] - nums[j] > mid) j++;
                count += i - j;
            }
            
            if(count < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}