class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer, Integer>hm = new HashMap<>();
        
        int ans = 0;
        
        for(int i=0; i<time.length; i++){
            int val = time[i];
            int rem = val % 60;
            if(!hm.containsKey(rem)) {
                hm.put(rem, 0);
            }
            if(hm.containsKey((60-(rem)) %60)) ans += hm.get((60-(rem))%60);
            hm.put(rem, hm.get(rem)+1);
        }
        return ans;
    }
      
    /*
        for(int i=0; i<time.length; i++){
            int val = time[i];
            if(hm.containsKey(60-val)){
                List<Integer>ls = hm.get(60-val);
                count += binary(ls, i);
            }
        }
    }
    public int binary(List<Integer>al, int i){
        int lo = 0;
        int hi = al.size();
        while(lo > hi) {
            int mid = lo + (hi-lo)/2;
            if(al.get(mid) > i) {
                
            } else if(al.get(mid) < i) {
                
            } else {
                return al.size()-mid;
            }
        }
        return al.size()-lo;
    }
    */
}