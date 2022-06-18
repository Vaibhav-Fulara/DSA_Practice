// Memoization
// TC = O(n^2)
// SC = O(n^2) + O(n)
/*
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][]dp = new int[nums.length][nums.length];
        for(int[]arr:dp) Arrays.fill(arr, -1);
        return getLIS(nums, -1, dp, 0);
    }
    public int getLIS(int[]arr, int prev, int[][]dp, int i){
        if(i == arr.length) return 0;
        if(prev != -1 && dp[prev][i] != -1) return dp[prev][i];
        
        int max = Integer.MIN_VALUE, inc = Integer.MIN_VALUE;
        
        if(prev == -1 || arr[i] > arr[prev]) inc = 1 + getLIS(arr, i, dp, i+1);
        int ign = getLIS(arr, prev, dp, i+1);
        
        if(prev != -1) return dp[prev][i] = Math.max(inc, ign);
        return Math.max(inc, ign);
    }
}
*/

// Tabulation
// TC = O(n^2)
// SC = O(n^2)
/*
class Solution {
    public int lengthOfLIS(int[] arr) {
        int[][]dp = new int[arr.length + 1][arr.length + 1];
        
        for(int i = arr.length-1; i >= 0; i--){
            for(int prev = i-1; prev >= -1; prev--){    // as prev can start from i-1 as it is previous of current element
                int inc = Integer.MIN_VALUE;
        
                if(prev == -1 || arr[i] > arr[prev]) inc = 1 + dp[i+1][i+1];
                int ign = dp[i+1][prev+1];

                dp[i][prev+1] = Math.max(inc, ign);
            }
        }
        return dp[0][0];
    }
}
*/

// Spatial optimization
// TC = O(n^2)
// SC = O(n)
/*
class Solution {
    public int lengthOfLIS(int[] arr) {
        int[]pre = new int[arr.length + 1];
        
        for(int i = arr.length-1; i >= 0; i--){     // as prev can start from i-1 as it is previous of current element
            int[]curr = new int[arr.length + 1];
            for(int prev = i-1; prev >= -1; prev--){
                int inc = Integer.MIN_VALUE;
        
                if(prev == -1 || arr[i] > arr[prev]) inc = 1 + pre[i+1];
                int ign = pre[prev+1];

                curr[prev+1] = Math.max(inc, ign);
            }
            pre = curr;
        }
        return pre[0];
    }
}
*/

// Another Approach
// TC = O(n^2)
// SC = O(n)
/*
class Solution {
    public int lengthOfLIS(int[] arr) {
        int amax = 1;
        int[]dp = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i]) max = Math.max(max, dp[j]);
            }
            dp[i] = max+1;
            amax = Math.max(amax, dp[i]);
        }    
        return amax;
    }
}
*/

// How to print LIS
/*
class Solution {
    public int lengthOfLIS(int[] arr) {
        String amax = Integer.toString(arr[0]);
        String[]dp = new String[arr.length];
        for(int i=0; i<arr.length; i++){
            String val = Integer.toString(arr[i]);
            String max = val;
            for(int j=0; j<i; j++) if(arr[j] < arr[i] && dp[j].length() + 1 > max.length()) max = dp[j] +", "+ val;
            dp[i] = max;
            if(dp[i].length() > amax.length()) amax = dp[i];
        }    
        System.out.println(amax);
        return amax.split(" ").length;
    }
}
*/

// Another Way to print LIS
/*
class Solution {
    public int lengthOfLIS(int[] arr) {
        int max = 1, lastidx = 0;
        
        int[]dp = new int[arr.length];
        Arrays.fill(dp,1);
        
        int[]hash = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            hash[i] = i;
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
            
            if(dp[i] > max){
                lastidx = i;
                max = dp[i];
            }
        }
        
        int[]ans = new int[max];
        int i = max-1;
        
        while(hash[lastidx] != lastidx){
            ans[i--] = arr[lastidx];
            lastidx = hash[lastidx];
        }
        ans[0] = arr[lastidx];
        
        for(int val:ans) System.out.print(val + " ");
        System.out.println();
        
        return max;
    }
}
*/

// Best Approach (Using Binary Search)
class Solution {
    public int lengthOfLIS(int[] arr) {
        List<Integer>al = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            int j = binSearch(al, arr[i]);
            if(j == al.size()) al.add(arr[i]);
            else al.set(j, arr[i]);
        }
        return al.size();
    }
    public int binSearch(List<Integer>al, int val){
        int lo = 0;
        int hi = al.size();
        while(hi > lo){
            int mid = lo + (hi-lo)/2;
            if(al.get(mid) < val) lo = mid+1;
            else hi = mid;
        }
        return hi;
    }
}