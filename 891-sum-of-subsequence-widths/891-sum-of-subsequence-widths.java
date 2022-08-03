class Solution {
    long big = 1_00_00_00_007L;
    public int sumSubseqWidths(int[]arr) {
        Arrays.sort(arr);
        long ans = 0L;
        long mul = 1L;
        int n = arr.length;
        
        for(int i=0; i<n; i++) {
            ans += mul * arr[i];
            ans -= mul * arr[n-i-1];
            ans %= big;
            mul *= 2;
            mul %= big;
        }
        
        return (int)(ans % big);
    }
}