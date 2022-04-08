class KthLargest {
    
    PriorityQueue<Integer>pq;
    int k=0;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for(int val:nums) this.add(val);
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size()>k) pq.remove(); 
        return pq.peek();
    }
}