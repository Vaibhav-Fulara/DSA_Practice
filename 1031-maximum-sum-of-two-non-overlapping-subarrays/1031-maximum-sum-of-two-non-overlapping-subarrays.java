class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int first, int second) {
        return Math.max(solve(nums, first, second), solve(nums, second, first));
    }
    
    public int solve(int[]arr, int n1, int n2) {
        int n = arr.length;
        int[]left = new int[n];
        int[]right = new int[n];
        
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            if(i == n1-1) {
                left[i] = sum;
            } else if(i >= n1) {
                sum -= arr[i-n1];
                left[i] = Math.max(left[i-1], sum);
            }
        }
        
        sum = 0;
        for(int i = n-1; i >= 0; i--) {
            sum += arr[i];
            if(i == n-n2) {
                right[i] = sum;
            } else if(i < n-n2) {
                sum -= arr[i+n2];
                right[i] = Math.max(right[i+1], sum);
            }
        }
        
        int max = 0;
        for(int i=n1-1; i<arr.length-n2; i++) max = Math.max(left[i] + right[i+1], max);
        return max;
    }
}