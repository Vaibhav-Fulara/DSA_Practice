class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int lo=0;
        int hi=arr.length;
        while(hi>lo){
            int mid=(hi+lo)/2;
            if(arr[mid]>arr[mid+1]) hi=mid;
            else lo=mid+1;
        }
        return hi;
    }
}