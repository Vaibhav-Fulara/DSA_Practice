class Solution {
    public boolean isPowerOfTwo(int x) {
        if(x <= 0) return false;
        if(x - (x & -x) == 0) return true;
        return false;
    }
}