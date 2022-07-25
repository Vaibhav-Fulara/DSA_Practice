// O(n) || O(n)
/*
class Solution {
    public int partitionDisjoint(int[]arr) {
        int n = arr.length;
        int[]smolFromRight = new int[n];
        int[]bigFromLeft = new int[n];
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int part = n;
        
        for(int i=0; i<arr.length; i++){
            bigFromLeft[i] = Math.max(max, arr[i]);
            smolFromRight[n-i-1] = Math.min(min, arr[n-i-1]);
            min = Math.min(min, arr[n-i-1]);
            max = Math.max(max, arr[i]);
        }
        
        for(int i=0; i<arr.length-1; i++) {
            if(bigFromLeft[i] <= smolFromRight[i+1]) {
                part = i+1;
                break;
            }
        }
        
        return part;
    }
}
*/

// O(1) || O(1)
class Solution {
    public int partitionDisjoint(int[]arr) {
        int mtp = arr[0];
        int max = arr[0];
        int part = 1;
        for(int i=1; i<arr.length; i++) {
            if(arr[i] < mtp) {
                mtp = max;
                part = i+1;
            }
            max = Math.max(arr[i], max);
        }
        return part;
    }
} 
