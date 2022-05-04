class Solution {
    public int maxOperations(int[]arr, int k) {
        Arrays.sort(arr);
        int count = 0;
        int n = arr.length, lo = 0, hi = n-1;
        
        while(lo < hi){
            if(arr[lo]+arr[hi]>k) hi--;
            else if(arr[lo] + arr[hi] == k) {
                count++;
                lo++;
                hi--;
            }
            else lo++;
        }
        return count;
    }
}