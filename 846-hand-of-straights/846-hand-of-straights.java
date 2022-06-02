class Solution {
    public boolean isNStraightHand(int[]arr, int k) {
        if(k == 1) return true;
        Map<Integer, Integer>tm = new TreeMap<>();
        for(int i=0; i<arr.length; i++) tm.put(arr[i], tm.getOrDefault(arr[i], 0) + 1);
        for(int val:tm.keySet()){
            if(tm.get(val)!=0){
                for(int i=1; i<k; i++){
                    if(tm.getOrDefault(val+i, 0) < tm.get(val)) return false;
                    tm.put(val+i, tm.get(val+i)-tm.get(val));
                }
            }
        }
        return true;
    }
}