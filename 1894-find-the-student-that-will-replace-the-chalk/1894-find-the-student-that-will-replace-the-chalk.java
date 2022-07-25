class Solution {
    public int chalkReplacer(int[]arr, int k) {
        long sum = 0;
        for(int num:arr) sum += num;
        k = (int) (k % sum);
        for(int i=0; i<arr.length; i++) {
            k -= arr[i];
            if(k < 0) return i;
        }
        return -1;
    }
}