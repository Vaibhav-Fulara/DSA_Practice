class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[]arr = new int[nums.length];
        int num = 1, den = 1;
        for(int i=0; i<nums.length; i++) {
            arr[i] = num;
            num *= nums[i];
        }
        for(int i=nums.length-1; i>=0; i--) {
            arr[i] *= den;
            den *= nums[i];
        }
        return arr;
    }
}