class Solution {
    public int findMaxConsecutiveOnes(int[]arr) {
        int max = 0, count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 1) count++;
            else{
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(max, count);
    }
}