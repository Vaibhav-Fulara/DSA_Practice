class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int station = 0;
        int fuelStock = 0;
        int n = stations.length;
        
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->b-a);
        pq.add(startFuel);
        for(int stationCount = 0; !pq.isEmpty(); stationCount++) {
            int curr = pq.remove();
            fuelStock += curr;
            if(fuelStock >= target) return stationCount;
            while(station < n && stations[station][0] <= fuelStock) {
                pq.add(stations[station][1]);
                station++;
            }
        }
        return -1;
    }
}