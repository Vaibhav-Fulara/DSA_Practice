class Solution {
    public int integerReplacement(int num) {
        long n = num;
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