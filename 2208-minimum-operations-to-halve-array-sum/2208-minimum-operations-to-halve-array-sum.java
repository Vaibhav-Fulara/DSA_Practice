class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double>pq = new PriorityQueue<>((a,b)-> {
            if(a >= b) return -1;
            return 1;
        });
        double sum = 0;
        int count = 0;
        
        for(int val:nums){
            pq.add((double)val);
            sum += val;
        }
        
        double val = 0;
        
        while(val < sum/2) {
            double temp = pq.remove();
            val += temp/2;
            pq.add(temp/2);
            count++;
        }
        
        return count;
    }
}