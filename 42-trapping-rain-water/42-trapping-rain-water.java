class Solution {
    public int trap(int[]arr) {
        int n = arr.length, ans = 0;
        
        int[]left =  new int[n];
        int[]right =  new int[n];
        
        int leftmax = arr[0];
        int rightmax = arr[n-1];
        
        for(int i=0; i<n; i++) {
            leftmax = Math.max(arr[i], leftmax);
            left[i] = leftmax;
            rightmax = Math.max(arr[arr.length - i - 1], rightmax);
            right[arr.length - i - 1] = rightmax;
        }
        
        for(int i=0; i<n; i++) if(arr[i] < left[i] && arr[i] < right[i]) ans += Math.min(left[i], right[i])-arr[i];
        return ans;
    }
}
