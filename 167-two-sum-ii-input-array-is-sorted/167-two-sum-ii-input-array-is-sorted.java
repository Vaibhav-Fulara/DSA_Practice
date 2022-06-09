class Solution {
    public int[] twoSum(int[]arr, int target) {
        int i = 0, j = arr.length-1;
        while(arr[i] + arr[j] != target){
            if(arr[i] + arr[j] < target) i++;
            else j--;
        }
        return new int[]{1+i, 1+j};
    }
}