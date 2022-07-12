class Solution {
    public int maximumDetonation(int[][] arr) {
        int n = arr.length;
        
        List<List<Integer>>adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j < arr.length; j++) {
                if(i == j) continue;
                int x1 = arr[i][0], y1 = arr[i][1], x2 = arr[j][0], y2 = arr[j][1], r1 = arr[i][2], r2 = arr[j][2];
                double dis = Math.pow(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2), 0.5d);
                // System.out.println(dis + " " + r1);
                if(dis <= r1)adj.get(i).add(j);
            }
        }
        
        int max = 1;
        for(int i=0; i<n; i++) {
            boolean[]vis = new boolean[n];
            vis[i] = true;
            max = Math.max(dfs(adj, i, vis), max);
        }
        return max;
    }
    
    public int dfs(List<List<Integer>>adj, int i, boolean[]vis){
        int count = 0;
        List<Integer>al = adj.get(i);
        for(int val:al){
            if(!vis[val]){
                vis[val] = true;
                count += dfs(adj, val, vis);
            }
        }
        return count+1;
    }
}