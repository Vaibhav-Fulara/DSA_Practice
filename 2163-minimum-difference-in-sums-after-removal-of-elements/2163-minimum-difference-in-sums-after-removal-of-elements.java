class Solution {
    public long minimumDifference(int[]arr) {
        int len = arr.length;
        int n = len/3;
        long[]prebig = new long[len];
        long[]postsmol = new long[len];
        
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->b-a);
        long sum = 0;
        for(int i=0; i<len; i++){
            sum += arr[i];
            pq.add(arr[i]);
            if(pq.size() > n){
                sum -= pq.remove();
            }
            prebig[i] = sum;
        }
        
        pq = new PriorityQueue<>();
        sum = 0;
        for(int i=len-1; i>=0; i--){
            sum += arr[i];
            pq.add(arr[i]);
            if(pq.size() > n){
                sum -= pq.remove();
            }
            // System.out.println(sum +" "+i);
            postsmol[i] = sum;
        }
        
        // System.out.println();
        
        long max = Long.MAX_VALUE;
        for(int i=n-1; i<2*n; i++) {
            // System.out.println(prebig[i] + " " + postsmol[i+1]);
            max = Math.min(prebig[i] - postsmol[i+1], max);
        }
        return max;
    }
}