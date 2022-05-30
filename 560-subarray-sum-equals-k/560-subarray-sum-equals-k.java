class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer>hm = new HashMap<>();
        int sum = 0, count = 0;
        hm.put(0,1);
        for(int i:nums){
            sum += i;
            count += hm.getOrDefault(sum-k,0);
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return count;
    }
}