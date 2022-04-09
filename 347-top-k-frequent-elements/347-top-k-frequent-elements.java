class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length==0) return new int[k];
        Map<Integer, Integer>hm = new HashMap<>();
        for(int val:nums) hm.put(val,hm.getOrDefault(val,0)+1);
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->{return hm.get(a)-hm.get(b);});
        for(int val:hm.keySet()){
            pq.add(val);
            if(pq.size()>k) pq.poll();
        }
        int[]ans = new int[k];
        int i=0;
        while(pq.size()!=0){
            ans[i++] = pq.poll();
        }
        return ans;
    }
}