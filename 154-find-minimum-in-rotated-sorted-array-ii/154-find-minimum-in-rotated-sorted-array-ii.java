class Solution {
    public int findMin(int[]arr) {
        for(int i=1; i<arr.length; i++) {
            if(arr[i-1] > arr[i]) return arr[i];
        }
        return arr[0];
    }
}