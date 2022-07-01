class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[]prefix = new int[arr.length];
        int max  = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            max = prefix[i] = Math.max(max, arr[i]);
        }
        int ans = 0;
        for(int i=0; i<arr.length; i++){
            if(prefix[i] == i) ans++;
        }
        return ans;
    }
}