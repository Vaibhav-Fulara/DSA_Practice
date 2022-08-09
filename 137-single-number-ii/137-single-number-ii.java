// O(n*32) || O(1)
/*
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
*/

class Solution {
    public int singleNumber(int[] arr) {
        int one = ~0;
        int two = 0, three = 0;

        for(int i=0; i<arr.length; i++) {
            int tnp1 = one & arr[i];
            int tnp2 = two & arr[i];
            int tnp3 = three & arr[i];

            one = (one & ~tnp1) | tnp3;
            two = (two & ~tnp2) | tnp1;
            three = (three & ~tnp3) | tnp2;
        }
        
        return two;
    }
}