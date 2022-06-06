class TopVotedCandidate {
    
    Map<Integer, Integer>time = new HashMap<>(), hm = new HashMap<>();
    int[]arr;
    int max = 0;
    int win = -1;
    
    public TopVotedCandidate(int[] persons, int[] times) {
        arr = times;
        for(int i=0; i<persons.length; i++){
            int val = hm.getOrDefault(persons[i], 0) + 1;
            if(val >= max){
                max = val;
                win = persons[i];
            }
            hm.put(persons[i], val);
            time.put(times[i], win);
        }
    }
    
    public int q(int t) {
        int tim = binSearch(t);
        return time.get(tim);
    }
    
    public int binSearch(int tim){
        int lo = 0, hi = arr.length-1;
        while(lo<hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid] == tim) return arr[mid];
            if(arr[mid] > tim) hi = mid-1;
            else {
                if(mid < arr.length-1 && arr[mid+1] > tim) return arr[mid];
                lo = mid+1;            
            }
        }
        return arr[hi];
    }
}
/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */