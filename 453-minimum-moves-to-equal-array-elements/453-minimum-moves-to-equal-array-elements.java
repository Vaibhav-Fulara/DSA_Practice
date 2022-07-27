class Solution {
    public int minMoves(int[] arr) {
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for(int i=0; i<arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        for(int i=0; i<arr.length; i++) {
            ans += arr[i]-min;
        }
        return ans;
    }
}