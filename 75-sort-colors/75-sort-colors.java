class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int two = 0;
        int n = nums.length;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0) zero++;
            else if(nums[i] == 2) two++;
        }
        Arrays.fill(nums, 1);
        for(int i=0; i<zero; i++) nums[i] = 0;
        for(int i=n-1; i>n-1-two; i--) nums[i] = 2;
    }
}