class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        
        Arrays.sort(nums);
        int av = n%2 != 0? nums[n/2] : (nums[n/2] + nums[n/2-1])/2;
        
        int steps = 0;
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            steps += Math.abs(av - num);
        }
        return steps;
    }
}