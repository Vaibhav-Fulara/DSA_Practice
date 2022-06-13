class Solution {
    public int maxProfit(int[]arr) {
        
        int lo = arr[0], max = 0;
        
        for(int i=1; i<arr.length; i++){
            max = Math.max(max, arr[i] - lo);
            lo = Math.min(arr[i], lo);
        }
        
        return max;
    }
}