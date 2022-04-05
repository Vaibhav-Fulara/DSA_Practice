class Solution {
    int water = 0;
    // public int maxArea(int[]arr) {
    //     for(int i=0; i<arr.length-1; i++){
    //         int left = arr[i];
    //         for(int j=i+1; j<arr.length; j++){
    //             int right = arr[j];
    //             water = Math.max(water, Math.min(left,right)*(j-i));
    //         }
    //     }
    //     return water;
    // }
    
    public int maxArea(int[]arr) {
        int left = 0, right = arr.length-1;
        int water = 0;
        while(left<=right){
            water = Math.max(water, (right-left)*Math.min(arr[right], arr[left]));
            if(arr[right]>arr[left]) left++;
            else if (arr[left]>arr[right]) right--;
            else {left++; right--;}
        }
        return water;
    }
}