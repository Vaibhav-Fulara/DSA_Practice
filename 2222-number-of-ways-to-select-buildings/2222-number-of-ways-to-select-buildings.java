class Solution {
    public long numberOfWays(String s) {
        long zero = 0, one = 0, oneZero = 0, zeroOne = 0, oneZeroOne = 0, zeroOnezero = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) =='0') {
                zero++;
                oneZero += one;
                zeroOnezero += zeroOne;
            } else {
                one++;
                zeroOne += zero;
                oneZeroOne += oneZero;
            }
        }
        return oneZeroOne + zeroOnezero;
    }
}