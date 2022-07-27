class Solution {
    public int minMoves2(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int med = arr[n/2];
        int ans = 0;
        for(int i=0; i<arr.length; i++) {
            ans += Math.abs(arr[i]-med);
        }
        return ans;
    }
}