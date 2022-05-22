class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int max = -1;
        for(int val:right) {
            if(max < n - val) max = n-val;
        }
        for(int val:left) if(max < val) max = val;
        return max;
    }
}