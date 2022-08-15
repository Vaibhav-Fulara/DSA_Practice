class Solution {
    public int maximumGap(int[]arr) {
        if(arr.length < 2) return 0;
        Arrays.sort(arr);
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length-1; i++) {
            max = Math.max(arr[i+1]-arr[i], max);
        }
        return max;
    }
}