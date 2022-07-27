class Solution {
    public int minMoves(int[] arr) {
        Arrays.sort(arr);
        int ans = 0;
        int n = arr.length;
        for(int i=n-1; i>0; i--) {
            if (arr[i] > arr[i-1]) {
                ans += (arr[i] - arr[i-1]) * (n-i);
            } else if (arr[i] < arr[i-1]) {
                ans += arr[i-1] - arr[i];
                arr[i-1] = arr[i];
            }
        }
        return ans;
    }
}