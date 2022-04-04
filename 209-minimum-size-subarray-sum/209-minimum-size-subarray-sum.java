class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int start = 0, end = 0, sum = 0, moves = Integer.MAX_VALUE;
        while(end<arr.length){
            sum += arr[end];
            end++;
            while(sum>=target){
                moves = Math.min(moves, end-start);
                sum-=arr[start];
                start++;
            }
        }
        return moves==Integer.MAX_VALUE? 0:moves;
    }
}