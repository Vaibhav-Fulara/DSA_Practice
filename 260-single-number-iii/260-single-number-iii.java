class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums.length == 2) return nums;
        int val = 0;
        for(int n:nums) val ^= n;
        int rsb = val & -val;
        
        int n1 = 0, n2 = 0;
        for(int n:nums) {
            if((rsb & n) == 0) n1 ^= n;
            else n2 ^= n;
        }
        return new int[]{n1,n2};
    }
}