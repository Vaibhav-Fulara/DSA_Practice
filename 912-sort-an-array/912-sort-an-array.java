// Merge Sort
//
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

// Insertion Sort
//
// class Solution {
//     public int[] sortArray(int[]arr) {
//         int n = arr.length;
//         for(int i=1; i<n; i++){
//             for(int j=i-1; j>=0; j--){
//                 if(arr[j]>arr[j+1]){
//                     int temp = arr[j+1];
//                     arr[j+1] = arr[j];
//                     arr[j] = temp;
//                 }
//                 else break;
//             }            
//         }
//         return arr;
//     }
// }

// Selection Sort [TLE]
//
// class Solution {
//     public int[] sortArray(int[]arr) {
//         int n = arr.length;
//         for(int i=0; i<n-1; i++){
//             int min = i;
//             for(int j=i+1; j<n; j++){
//                 if(arr[j]<arr[min]) min = j;
//             }
//             int temp = arr[i];
//             arr[i] = arr[min];
//             arr[min] = temp;
//         }
//         return arr;
//     }
// }


// Bubble Sort [TLE]
//
// class Solution {
//     public int[] sortArray(int[]arr) {
//         int n = arr.length;
//         for(int i=1; i<=n-1; i++){
//             for(int j=0; j<n-i; j++){
//                 if(arr[j]>arr[j+1]){
//                     int temp = arr[j];
//                     arr[j] = arr[j+1];
//                     arr[j+1] = temp;
//                 }
//             }
//         }
//         return arr;
//     }
// }

// In-Built Sort
//
// class Solution {
//     public int[] sortArray(int[] nums) {
//         return Arrays.sort(nums);
//     }
// }