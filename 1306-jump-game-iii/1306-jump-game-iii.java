class Solution {
    public boolean canReach(int[] arr, int start) {
        Set<Integer>hs = new HashSet<>();
        int[]dp = new int[arr.length];
        return getPath(arr, start, hs, dp);
    }
    public boolean getPath(int[]arr, int i, Set<Integer>hs, int[]dp){
        if(arr[i] == 0) return true;
        
        if(hs.contains(i)){
            dp[i] = -1;
            // System.out.println(1+ " " +i);
            return false;
        }
        
        if(dp[i] != 0) return dp[i] == -1 ? false:true;
        
        hs.add(i);
        
        if(i-arr[i] >= 0){
            if(getPath(arr, i-arr[i], hs, dp)) {
                dp[i-arr[i]] = 1;
                return true;
            }
        }
        
        if(i+arr[i] < arr.length){
            if(getPath(arr, i+arr[i], hs, dp)) {
                dp[i+arr[i]] = 1;
                return true;
            }
        }
        
        hs.remove(i);
        
        dp[i] = -1;
        // System.out.println(2+ " " +i);
        return false;
    }
}