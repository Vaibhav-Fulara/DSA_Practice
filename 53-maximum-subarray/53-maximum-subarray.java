// Kadanes algorithm
class Solution {
    public int maxSubArray(int[]arr) {
        int max = Integer.MIN_VALUE;
        int curr = 0;
        for(int i=0; i<arr.length; i++) {
            curr += arr[i];
            max = Math.max(curr, max);
            if(curr < 0) curr = 0;
        }
        return max;
    }
}