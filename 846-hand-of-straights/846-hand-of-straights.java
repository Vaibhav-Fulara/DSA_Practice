class Solution {
    public boolean isNStraightHand(int[]arr, int k) {
        if(k == 1) return true;
        Map<Integer, Integer>tm = new TreeMap<>();
        for(int i=0; i<arr.length; i++) tm.put(arr[i], tm.getOrDefault(arr[i], 0) + 1);
        for(int val:tm.keySet()){
            while(tm.get(val)!=0){
                for(int i=1; i<k; i++){
                    if(tm.getOrDefault(val+i, 0) <= 0) return false;
                    tm.put(val+i, tm.get(val+i)-1);
                }
                tm.put(val, tm.get(val)-1);
            }
        }
        return true;
    }
}