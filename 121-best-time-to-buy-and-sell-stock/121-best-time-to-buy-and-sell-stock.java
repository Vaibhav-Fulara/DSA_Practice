class Solution {
    public int maxProfit(int[]arr) {
        
        int[]small = new int[arr.length];
        
        for(int i=0; i<arr.length; i++){
            if(i == 0)  small[i] = arr[i];
            else small[i] = Math.min(arr[i], small[i-1]);
        }
        
        int max = 0;
        for(int i=0; i<arr.length; i++) max = Math.max(max, arr[i]-small[i]);
        return max;
    }
}