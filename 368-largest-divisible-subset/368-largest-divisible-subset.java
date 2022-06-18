class Solution {
    public List<Integer> largestDivisibleSubset(int[]arr) {
        int max = 1, lastidx = 0;
        
        Arrays.sort(arr);
        
        int[]dp = new int[arr.length];
        Arrays.fill(dp,1);
        
        int[]hash = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            hash[i] = i;
            for(int j=0; j<i; j++){
                if(arr[i] % arr[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
            
            if(dp[i] > max){
                lastidx = i;
                max = dp[i];
            }
        }
        
        Integer[]ans = new Integer[max];
        int i = max-1;
        
        while(hash[lastidx] != lastidx){
            ans[i--] = arr[lastidx];
            lastidx = hash[lastidx];
        }
        ans[0] = arr[lastidx];
        
        return Arrays.asList(ans);
    }
}