class Solution {
    public int distributeCookies(int[]arr, int k) {
        int sum = 0;
        for(int i:arr) sum += i;
        int[]ans = new int[k];
        return getMin(arr, ans,  0);
    }
    
    public int getMin(int[]arr, int[]ans, int i){
        if(i == arr.length){
            int max = 0;
            for(int val:ans) max = Math.max(max, val);
            return max;
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int j=0; j<ans.length; j++){
            ans[j] += arr[i];
            min = Math.min(getMin(arr, ans, i+1), min);
            ans[j] -= arr[i];
        }
        
        return min;
    }
}