class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[]maxpre = new int[n];
        int[]minpost = new int[n];
        maxpre[0] = arr[0];
        minpost[n-1] = arr[n-1];
        int count = 0;
        for(int i=1; i<arr.length; i++) maxpre[i] = Math.max(maxpre[i-1], arr[i]);
        for(int i=n-2; i>=0; i--) minpost[i] = Math.min(arr[i], minpost[i+1]);
        for(int i=0; i<n-1; i++) if(minpost[i+1] >= maxpre[i]) count++;
        return count+1;
    }
}