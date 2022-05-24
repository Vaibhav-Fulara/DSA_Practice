class Solution {
    public int removeDuplicates(int[]arr) {
        int idx = 1;
        int prev = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i] != prev) {
                arr[idx++] = arr[i];
                prev = arr[i];
            }
        }
        return idx;
    }
}