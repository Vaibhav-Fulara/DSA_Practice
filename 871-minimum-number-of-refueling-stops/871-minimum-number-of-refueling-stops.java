class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int curr = 0;
        int fuel = 0;
        
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->b-a);
        pq.add(startFuel);
        
        for(int count = 0; !pq.isEmpty(); count++) {
            int best = pq.remove();
            fuel += best;
            if(fuel >= target) return count;
            while(curr < stations.length && stations[curr][0] <= fuel) {
                pq.add(stations[curr][1]);
                curr++;
            }
        }
        return -1;
    }
}