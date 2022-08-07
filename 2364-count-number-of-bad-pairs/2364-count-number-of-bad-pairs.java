class Solution {
    public long countBadPairs(int[]arr) {
        long count = 0l;
        int n = arr.length;
        Map<Integer, Integer>hm = new HashMap<>();
        for(int i=0; i<n; i++) {
            int pre = hm.getOrDefault(i-arr[i], 0);
            count += pre;
            hm.put(i-arr[i], pre+1);
        }
        return (long) n*(n-1) / 2 - count;
    }
}