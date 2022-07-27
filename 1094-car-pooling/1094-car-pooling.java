//O(n^2)
/*
class Solution {
    public boolean carPooling(int[][] trips, int cap) {
        Map<Integer, Integer>hm = new HashMap<>();
        for(int[]arr:trips){
            int lo = arr[1];
            int hi = arr[2];
            for(int i=lo; i<hi; i++){
                int k = hm.getOrDefault(i,0);
                if(k+arr[0] > cap) return false;
                else hm.put(i, k+arr[0]);
            }
        }
        return true;
    }
}
*/


// O(n)
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int in_car = 0;
        int[] increase = new int[1001];
        for (int i = 0; i < trips.length; i ++) { // find out the number of the **net increase** passengers for each stop
            increase[trips[i][1]] += trips[i][0];
            increase[trips[i][2]] -= trips[i][0];
        }
        for (int i = 0; i <= 1000; i ++) { // from start to end, for each stop we calculate the number of passengers in the car.
            in_car += increase[i];
            if (in_car > capacity) return false; // once the number of passengers in the car exceeds the capacity
        }
        return true;
    }
}