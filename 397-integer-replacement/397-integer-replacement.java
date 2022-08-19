class Solution {
    public int integerReplacement(int n) {
        if(n == Integer.MAX_VALUE) return 32;
        int count = 0;
        while(n != 1) {
            count++;
            if((n&1) != 1) n /= 2;
            else if(n == 3) {
                return count+1;
            } else if((n-1) % 4 == 0) {
                n -= 1;
            } else {
                n += 1;
            }
        }
        return count;
    }
}