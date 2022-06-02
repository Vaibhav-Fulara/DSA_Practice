class Solution {
    public boolean canPartition(int[]arr) {
        int sum = 0;
        for(int val:arr) sum += val;
        if(sum % 2 != 0) return false;
        int k = sum/2;
        
        boolean[]prev = new boolean[k + 1];
        prev[0] = true;
        
        for(int i=arr.length-1; i>=0; i--){
            
            boolean[]curr = new boolean[k + 1];
            curr[0] = true;
            
            if(arr[i] <= k) curr[arr[i]] = true;
            for(int tar = 1; tar<=k; tar++){
                boolean contain = false;
                if(arr[i] <= tar) contain = prev[tar - arr[i]];
                boolean ignore = prev[tar];
                curr[tar] = contain || ignore;
            }
            prev = curr;
        }
        return prev[k];
    }
}