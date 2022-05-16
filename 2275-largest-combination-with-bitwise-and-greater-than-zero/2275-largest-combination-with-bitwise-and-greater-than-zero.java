class Solution {
    public int largestCombination(int[]a) {
        int bit[] = new int[32];
        int n = a.length;
        for (int i = 0; i < n; i++){
            int x = 31;
            if(a[i]==0) break;
            while (a[i] > 0) {
                if ((a[i] & 1) == 1) bit[x]++;
                a[i] = a[i] >> 1;
                x--;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 32; i++)  max = Math.max(max, bit[i]);
        return max;
    }
}