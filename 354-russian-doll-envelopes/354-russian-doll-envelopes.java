class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            int cmp = Integer.compare(a[0], b[0]);
            return cmp != 0 ? cmp : -Integer.compare(a[1], b[1]);
        });
        
        int len = 0;
        int[] dp = new int[envelopes.length];
        for (int[] e : envelopes) {
            int pos = Arrays.binarySearch(dp, 0, len, e[1]);
            if (pos < 0) {
                pos = -pos - 1;
            }
            dp[pos] = e[1];
            if (pos == len) {
                len++;
            }
        }
        return len;
    }
}