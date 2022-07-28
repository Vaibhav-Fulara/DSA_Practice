class Solution {
    public int consecutiveNumbersSum(int n) {
        int k = 1;
        int ans = 0;
        int check = k * (k-1) / 2;
        while(check < n) {
            if((n-check) % k == 0) ans++;
            k++;
            check = k * (k-1) / 2;
        }
        return ans;
    }
}