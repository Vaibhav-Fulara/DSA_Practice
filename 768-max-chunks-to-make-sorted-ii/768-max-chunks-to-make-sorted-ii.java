class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        
        int[]minToRight = new int[n];
        int[]maxToLeft = new int[n];
        maxToLeft[0] = arr[0];
        minToRight[n-1] = arr[n-1];
        
        for(int i=1; i<n; i++){
            maxToLeft[i] = Math.max(maxToLeft[i-1], arr[i]);
            minToRight[n-i-1] = Math.min(minToRight[n-i], arr[n-i-1]);
        }
        
        int ans = 0;
        for(int i=0; i<n-1; i++){
            if(maxToLeft[i] <= minToRight[i+1]) ans++;
        }
        return ans+1;
    }
}