class Solution {
    public int[] countBits(int n) {
        int[]dp = new int[n+1];
        int off = 1;
        
        for(int i=1; i<dp.length; i++){
            if(off*2 == i) off = i;
            dp[i] = 1+dp[i-off];
        }
        
        return dp;
    }
}

/*
00001  1  1

00010  2  1
00011  3  2

00100  4  1
00101  5  2
00110  6  2
00111  7  3

01000  8  1
01001  9  2
01010  10 2
01011  11 3
01100  12 2
01101  13 3
01110  14 3
01111  15 4

10000  16 1
10001  17 2
10010  18 2
10011  19 3
10100  20 2
10101  21 3
10110  22 3
10111  23 4
11000  24 2
11001  25 3
11010  26 3
11011  27 4
11100  28 3
11101  29 4
11110  30 4
11111  31 5

100000 32 1
*/