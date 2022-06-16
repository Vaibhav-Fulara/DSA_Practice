class Solution {
    
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>>hm = new HashMap<>();
        
        for(int i=0; i<arr.length; i++){
            int val = arr[i];
            if(! hm.containsKey(val)) hm.put(val, new ArrayList<>());
            hm.get(val).add(i);
        }
        
        int step = 0;
        
        Queue<Integer>qu = new ArrayDeque<>();
        qu.add(0);
        
        while(!qu.isEmpty()){
            int s = qu.size();
            for(int idx=0; idx < s; idx++){
                int i = qu.poll();
                
                if(i == arr.length-1) return step;
                
                if(i != 0 && hm.containsKey(arr[i-1])) qu.add(i-1);
                    
                if(hm.containsKey(arr[i+1])){
                    if(i+1 == arr.length-1) return step+1;
                    qu.add(i+1);
                } 
                    
                if(hm.containsKey(arr[i])){
                    for(int val:hm.get(arr[i])){
                        if(val != i) qu.add(val);
                        if(val == arr.length-1) return step + 1;
                    } 
                    hm.remove(arr[i]);
                }
            }
            step++;
        }
        
        return step;
    }
}