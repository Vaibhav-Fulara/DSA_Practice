class Solution {
    public int maxProfit(int[]arr) {
        
        int[]big = new int[arr.length];
        int[]small = new int[arr.length];
        
        for(int i=0; i<arr.length; i++){
            int j = arr.length-1-i;
            if(i == 0){
                small[i] = arr[i];
                big[j] = arr[j];
            }
            else{
                small[i] = Math.min(arr[i], small[i-1]);
                big[j] = Math.max(arr[j], big[j+1]);
            }
        }
        
        int max = 0;
        for(int i=0; i<arr.length; i++) max = Math.max(max, big[i]-small[i]);
        return max;
    }
}