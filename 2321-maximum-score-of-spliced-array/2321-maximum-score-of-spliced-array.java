class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int sum1 = 0, sum2 = 0;
        
        for(int val:nums1) sum1 += val;
        for(int val:nums2) sum2 += val;
        int ans = Math.max(sum1, sum2);
        
        int first = 0, second = 0, max1 = 0, max2 = 0;
        
        for(int i=0; i<nums1.length; i++){
            first += nums2[i] - nums1[i];
            second += nums1[i] - nums2[i];
            
            max1 = Math.max(max1, first);
            max2 = Math.max(max2, second);
            
            if(first < 0) first = 0;
            if(second < 0) second = 0;
        }
        
        ans = Math.max(sum1 + max1, sum2 + max2);
        return ans;
    }
}
