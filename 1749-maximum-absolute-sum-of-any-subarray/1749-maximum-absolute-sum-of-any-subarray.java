class Solution {
    public int maxAbsoluteSum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        int currn = 0;
        int currp = 0;
        
        for(int i=0; i<arr.length; i++) {
            currp += arr[i];
            currn += arr[i];
            max = Math.max(currp, max);
            min = Math.min(currn, min);
            if(currp < 0) currp = 0;
            if(currn > 0) currn = 0;
        }
        
        return max > -min? max:-min;
    }
}