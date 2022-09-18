class Solution {
    public int trap(int[]arr) {
        int[]pre = new int[arr.length];
        int[]post = new int[arr.length];
        pre[0] = arr[0];
        post[arr.length-1] = arr[arr.length-1];
        
        for(int i=1; i<arr.length; i++) {
            pre[i] = Math.max(pre[i-1], arr[i]);
            post[arr.length-i-1] = Math.max(arr[arr.length-i-1], post[arr.length-i]);
        }
        
        int ans = 0;
        for(int i=1; i<arr.length-1; i++) {
            if(arr[i] < pre[i-1] && arr[i] < post[i+1]) {
                ans += Math.min(pre[i-1], post[i+1]) - arr[i];
            }
        }
        return ans;
    }
}