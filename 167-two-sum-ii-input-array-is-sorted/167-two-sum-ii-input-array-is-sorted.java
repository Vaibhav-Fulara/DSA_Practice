class Solution {
    public int[] twoSum(int[]arr, int tar){
        int i = 0, j = arr.length-1;
        while(true){
            if(arr[i] + arr[j] == tar) return new int[] {i + 1, j + 1};
            else if(arr[i] + arr[j] > tar) j--;
            else i++;
        }
    }
}