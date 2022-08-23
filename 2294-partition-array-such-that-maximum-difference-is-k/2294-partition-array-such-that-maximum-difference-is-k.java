class Solution {
    public int partitionArray(int[]arr, int k) {
        Arrays.sort(arr);
        int count = 0;
        for(int i=arr.length-1; i>=0; i--) {
            int init = arr[i];
            count++;
            while(i >= 0 && init - arr[i] <= k) i--;
            i++;
        }
        return count;
    }
}