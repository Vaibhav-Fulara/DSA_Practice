class Solution {
    public int findDuplicate(int[]arr) {
        for(int val:arr){
            if(arr[Math.abs(val)] <0) return Math.abs(val);
            else arr[Math.abs(val)] *= -1;
        }
        return -1;
    }
}