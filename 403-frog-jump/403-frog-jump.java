// Memoization AC
class Solution {
    public boolean canCross(int[]arr) {
        if(arr[1] != 1) return false;
        
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            hm.put(arr[i], i);
        }
        
        int[][]dp = new int[arr.length][arr.length];
        return traverse(arr, dp, 1, 1, hm);
    }
    public boolean traverse(int[]arr, int[][]dp, int i, int k, Map<Integer, Integer>hm){
        if(i == arr.length-1){
            dp[i][k] = 1;
            return true;
        }
        
        if(dp[i][k] != 0){
            return dp[i][k] == 1? true:false;
        }
        
        dp[i][k] = 1;
        if(hm.containsKey(arr[i]+k)){
            // System.out.println("a" +" "+ i+" "+k);
            if(traverse(arr, dp, hm.get(arr[i]+k), k, hm)) return true;
        } 
        if(hm.containsKey(arr[i]+k+1)){
            // System.out.println("b" + " " + i+" "+k);
            if(traverse(arr, dp, hm.get(arr[i]+k+1), k+1, hm)) return true;
        } 
        if(k>1 && hm.containsKey(arr[i]+k-1)) {
            // System.out.println("c" + " " + i+" "+k);
            if(traverse(arr, dp, hm.get(arr[i]+k-1), k-1, hm)) return true;
        }
        dp[i][k] = -1;
        
        return false;
    }
}
// Tabulation TLE
/*
class Solution {
    public boolean canCross(int[]arr) {
        if(arr[1] != 1) return false;
        
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<arr.length; i++)  hm.put(arr[i], i);
        
        boolean[][]dp = new boolean[arr.length][arr.length];
        
        for(int i=arr.length-1; i>=0; i--){
            for(int k=arr.length-1; k>=0; k--){
                if(i == arr.length-1){
                    dp[i][k] = true;
                    continue;
                }

                if(hm.containsKey(arr[i]+k)) if(dp[hm.get(arr[i]+k)][k]) {dp[i][k] = true; continue;}
                if(k+1 < arr.length && hm.containsKey(arr[i]+k+1)) if(dp[hm.get(arr[i]+k+1)][k+1]) {dp[i][k] = true; continue;}
                if(k>1 && hm.containsKey(arr[i]+k-1)) if(dp[hm.get(arr[i]+k-1)][k-1]) {dp[i][k] = true; continue;}
                dp[i][k] = false;
            }
        }
        
        return dp[1][1];
    }
}
*/