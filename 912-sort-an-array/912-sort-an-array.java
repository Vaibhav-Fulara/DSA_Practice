class Solution {
    public int[] sortArray(int[] nums) {
        return getMerged(nums, 0, nums.length-1);
    }
    public int[] getMerged(int[]arr, int lo, int hi){
        if(lo==hi) return new int[]{arr[lo]};
        int mid = (lo+hi)/2;
        int[]left = getMerged(arr, lo, mid);
        int[]right = getMerged(arr, mid+1, hi);
        return mergeSorted(left,right);
    }
    public int[] mergeSorted(int[]a, int[]b){
        int n = a.length;
        int m = b.length;
        int x=0, y=0, i=0;
        int[]arr = new int[n+m];
        while(x<n && y<m){
            if(a[x]<b[y]) arr[i++] = a[x++];
            else arr[i++] = b[y++];
        }
        for(int q=x; q<a.length; q++) arr[i++] = a[q];
        for(int q=y; q<b.length; q++) arr[i++] = b[q];
        return arr;
    }
}