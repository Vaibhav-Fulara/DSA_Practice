class Solution {
    public int findKthLargest(int[] nums, int k) {
        List<Integer>al = new ArrayList<>();
        for(int i=0; i<Math.min(nums.length, k); i++) al.add(nums[i]);
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        pq.addAll(al);
        for(int i = k; i < nums.length; ++i) {
            pq.add(nums[i]);
            pq.remove();
        }
        while(pq.size()>k) pq.remove();
        return pq.peek();
    }
}