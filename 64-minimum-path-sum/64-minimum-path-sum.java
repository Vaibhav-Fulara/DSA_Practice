class Solution {
    public int minPathSum(int[][]arr) {
        int m = arr.length-1, n= arr[0].length-1;
        int[][] dirs = {{1,0}, {0,1}};
        
        int[]prev = new int[n+1];
            
        for(int sr=m; sr>=0; sr--){
            int[]curr = new int[n+1];
            for(int sc=n; sc>=0; sc--){
                if(sr == m && sc == n) {
                    curr[sc] = arr[sr][sc];
                    continue;
                }
                int one = Integer.MAX_VALUE;
                int two = Integer.MAX_VALUE;
                
                if(sr < m) one = prev[sc];
                if(sc < n) two = curr[sc+1];
                
                int min = Math.min(one, two);
                curr[sc] = min + arr[sr][sc];
            }
            prev = curr;
        }
        return prev[0];
    }
}