class Solution {
    public int numBusesToDestination(int[][]graph, int src, int tar) {
        if(src == tar) return 0;
        
        int max = 0;
        
        Map<Integer, List<Integer>>map = new HashMap<>();
        for(int i=0; i<graph.length; i++){
            for(int val:graph[i]){
                if( ! map.containsKey(val)) map.put(val, new ArrayList<>());
                map.get(val).add(i);
                max = Math.max(max, val);
            }
        }
        
        boolean[]vis = new boolean[max+1];
        int steps = 0;
        
        Queue<Integer>qu = new LinkedList<>();
        for(int val:map.get(src)) {
            qu.add(val);
            // System.out.println(val);
            vis[val] = true;
        }
        
        while(qu.size() != 0){
            steps++;
            int len = qu.size();
            for(int i=0; i<len; i++){
                int top = qu.poll();
                // System.out.println(top);
                for(int temp : graph[top]){
                    if(temp == tar) return steps;
                    for(int val : map.get(temp)){
                        if( ! vis[val]) {
                            qu.add(val);
                            // System.out.println(val);
                        }
                        vis[val] = true;
                    }
                }
            }
        }
        
        return -1;
    }
}