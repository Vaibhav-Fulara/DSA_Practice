// O(n^2)
// Check for all positive destinations
/*
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        for(int i=0; i<gas.length; i++) sum += gas[i]-cost[i];
        if(sum < 0) return -1;
        for(int i=0; i<gas.length; i++) {
            int cap = 0;
            if(gas[i] - cost[i] >= 0) {
                int src = i;
                boolean bool = true;
                while(src < gas.length) {
                    if(cap + gas[src]-cost[src] < 0) {
                        bool = false;
                        break;
                    }
                    cap = cap + gas[src]-cost[src];
                    src++;
                }
                src = 0;
                while(src != i) {
                    if(cap + gas[src]-cost[src] < 0) {
                        bool = false;
                        break;
                    }
                    cap = cap + gas[src]-cost[src];
                    src++;
                }
                if(bool) return i;
            }
        }
        return -1;
    }
}
*/
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        for(int i=0; i<gas.length; i++) sum += gas[i]-cost[i];
        if(sum < 0) return -1;
        for(int i=0; i<gas.length; i++) {
            int cap = 0;
            if(gas[i] - cost[i] >= 0) {
                int src = i;
                while(src <= gas.length) {
                    if(src == gas.length) return i;
                    if(cap + gas[src] - cost[src] < 0) break;
                    cap = cap + gas[src] - cost[src];
                    src++;
                }
                i = src;
            }
        }
        return -1;
    }
}