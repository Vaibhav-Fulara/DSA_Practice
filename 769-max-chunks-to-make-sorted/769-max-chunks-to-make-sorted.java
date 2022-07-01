class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[]prefix = new int[arr.length];
        prefix[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            prefix[i] = Math.max(prefix[i-1], arr[i]);
        }
        int ans = 0;
        for(int i=0; i<arr.length; i++){
            if(prefix[i] == i) ans++;
        }
        return ans;
    }
}