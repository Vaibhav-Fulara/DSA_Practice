class Solution {
    public int carFleet(int tar, int[] pos, int[] speed) {        
        int[]diff = new int[pos.length];
        int idx = 0;
        for(int val:pos) diff[idx++] = tar - val;
        
        Map<Integer, Integer>hm = new HashMap<>();
        for(int i=0; i<pos.length; i++) hm.put(diff[i], speed[i]);
        
        Arrays.sort(diff);
        int ans = 1;
        double prevt = (double) diff[0]/hm.get(diff[0]);
        
        for(int j=1; j<diff.length; j++){
            int val = diff[j];
            double currt = (double) val/hm.get(val);
            if(currt > prevt ){
                ans ++;
                prevt = currt;
            }
        }
        
        return ans;
    }
}