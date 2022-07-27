class Solution {
    public int maxDistToClosest(int[]arr) {
        int left = -1;
        int max = 2;
        int start = -1;
        for(int i=0; i < arr.length; i++) {
            if(arr[i] == 1) {
                if(left == -1) start = i;
                max = Math.max(max, i - left);
                left = i;
            }
        }
        return Math.max(max/2, Math.max(start, arr.length - left - 1));
    }
}