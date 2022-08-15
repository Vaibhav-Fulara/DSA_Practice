class Solution {
    long count = 0l;
    public boolean isIdealPermutation(int[]arr) {
        mergeSort(arr, 0, arr.length-1);
        long local = 0;
        for(int i=0; i<arr.length-1; i++) {
            if(arr[i] > arr[i+1]) local++;
        }
        return local == count;
    }
    int[]mergeSort(int[]arr, int strt, int end) {
        if(strt > end) return new int[]{};
        if(strt == end) return new int[]{arr[strt]};
        
        int mid = (strt+end)/2;
        int[]left = mergeSort(arr, strt, mid);
        int[]right = mergeSort(arr, mid+1, end);
        int[]ans = new int[left.length + right.length];
        int i=0, j=0, k=0;
        while(i != left.length && j != right.length) {
            if(left[i] > right[j]) {
                ans[k++] = right[j++];
                count+=left.length-i;
            } else if(left[i] <= right[j]) {
                ans[k++] = left[i++];
            }
        }
        while(i != left.length) {
            ans[k++] = left[i++];
        } 
        while(j != right.length) {
            ans[k++] = right[j++];
        }
        
        return ans;
    }
}