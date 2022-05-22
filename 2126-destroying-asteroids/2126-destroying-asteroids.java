class Solution {
    public boolean asteroidsDestroyed(int mass, int[] arr) {
        Arrays.sort(arr);
        long m = mass;
        for(int val:arr){
            if(val > m) return false;
            m += val;
        }
        return true;
    }
}