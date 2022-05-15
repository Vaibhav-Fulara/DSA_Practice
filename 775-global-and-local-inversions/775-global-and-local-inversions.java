class Solution {
    public boolean isIdealPermutation(int[]arr) {
        for(int i=0; i<arr.length; i++){
            if(arr[i]-i >1 || arr[i]-i <-1) return false;
        }
        return true;
    }
}