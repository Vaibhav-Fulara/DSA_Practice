class Solution {
    public int minStoneSum(int[]arr, int k) {
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->b-a);
        int sum = 0;
        for(int val:arr) {
            pq.add(val);
            sum += val;
        }
        for(int i=0; i<k; i++) {
            int val = pq.remove();
            sum -= val/2;
            pq.add(val-val/2);
        }
        return sum;
    }
}