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