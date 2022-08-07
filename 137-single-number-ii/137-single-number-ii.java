class Solution {
    public int singleNumber(int[] nums) {
        int n = 0;
        for(int i = 0; i < 32; i++) {
            int val = 1 << (i);
            int counter = 0;
            for(int num:nums) {
                if((val & num) != 0) counter++;
            }
            if(counter % 3 == 1) n |= val;
        }
        return n;
    }
}