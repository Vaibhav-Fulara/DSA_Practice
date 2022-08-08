class Solution {
    public boolean isPowerOfFour(int n) {
        if(n <= 0) return false;
        int val = n & -n;
        if(n-val != 0) return false;
        int counter = 0;
        while(val != 0) {
            val >>>= (1);
            counter ++;
        }
        return counter % 2 != 0;
    }
}