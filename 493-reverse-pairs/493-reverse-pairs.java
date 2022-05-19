class Solution {
    int count = 0;
    
    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return count;
    }
    
    public long[] mergeSort(int[]arr, int lo, int hi) {
        if(lo == hi) return new long[]{arr[lo]};
        int mid = lo + (hi-lo)/2;
        long[]left = mergeSort(arr, lo, mid);
        long[]right = mergeSort(arr, mid + 1, hi);
        
        int i=0, j=0;
        while(i!=left.length){
            if(j == right.length) {count += j; i++;}
            else if(left[i] > right[j]*2) j++;
            else {count +=j; i++;}
        }
        
        return mergeSorted(left, right);
    }

    public long[] mergeSorted(long[]arr1, long[]arr2) {
        long[]arr = new long[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        int n = arr1.length;
        while(i<arr1.length && j< arr2.length){
            if(arr1[i] < arr2[j]) arr[k++] = arr1[i++];
            else arr[k++] = arr2[j++];
        }
        while(i!=arr1.length) arr[k++] = arr1[i++];
        while(j!=arr2.length) arr[k++] = arr2[j++];
        return arr;
    }
}