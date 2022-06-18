class Solution {
    public int longestMountain(int[] arr) {
        return largestBitonic(arr);
    }
    public int largestBitonic(int[]arr){
        int n = arr.length;
        int[]LIS = new int[n];
        int[]LDS = new int[n];
        
        Arrays.fill(LIS, 1);
        Arrays.fill(LDS, 1);
        
        for(int i=1; i<n; i++){
            int j = i-1;
            if(arr[j] < arr[i] && LIS[i] < LIS[j]+1) LIS[i] = LIS[j] + 1;
        }
        
        int max = 0;
        
        for(int i=n-2; i>=0; i--){
            int j = i+1;
            if(arr[j] < arr[i] && LDS[i] < LDS[j]+1) LDS[i] = LDS[j] + 1;
            if(LIS[i] > 1 && LDS[i] > 1) max = Math.max(max, LDS[i]+LIS[i]-1);
        }
        
        return max;
    }
}