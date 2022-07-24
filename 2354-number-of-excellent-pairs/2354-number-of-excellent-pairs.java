class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        Set<Integer>hs = new HashSet<>();
        for(int num:nums) hs.add(num);
        long[]arr = new long[30];
        long ans = 0l;
        for(int val:hs) {
            arr[Integer.bitCount(val)]++;
        }
        for(int i=0; i<30; i++) {
            for(int j=0; j<30; j++) {
                if(i+j >= k) ans += arr[i]*arr[j];
            }
        }
        return ans;
    }
}