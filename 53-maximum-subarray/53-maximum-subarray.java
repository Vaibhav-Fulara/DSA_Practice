class Solution {
    public int maxSubArray(int[] arr) {
        int sum = Integer.MIN_VALUE;
        int curr = 0;
        for(int i=0; i<arr.length; i++){
            curr += arr[i];
            sum = Math.max(curr, sum);
            if(curr<0) curr = 0;
        }
        return sum;
    }
}