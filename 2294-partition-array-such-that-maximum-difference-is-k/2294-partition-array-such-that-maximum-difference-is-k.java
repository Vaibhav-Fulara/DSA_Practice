class Solution{    
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        if(nums.length==1) return 1;
        int ans=1,pre=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]-pre>k){
                ans++;
                pre=nums[i];
            }
        }
        return ans;
    }
}