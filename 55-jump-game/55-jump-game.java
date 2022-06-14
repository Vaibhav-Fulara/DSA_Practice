public class Solution {
    public boolean canJump(int[]arr) {
       if(arr.length < 2) return true;
       
       for(int curr = arr.length-2; curr>=0; curr--){
           if(arr[curr] == 0){
               int neededJumps = 1;
               while(neededJumps > arr[curr]){
                   neededJumps++;
                   curr--;
                   if(curr < 0) return false;
               }
           }
       }
       return true;
    }
}