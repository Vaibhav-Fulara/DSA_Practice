class Solution {
    public int numRescueBoats(int[] arr, int limit) {
        Arrays.sort(arr);
        int i = 0, j = arr.length-1;
        int ans = 0;
        while (i <= j) {
            ans ++;
            if(arr[i] + arr[j] <= limit) i++;
            j--;
        }
        return ans;
    }
}