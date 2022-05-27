class Solution {
    public int minFallingPathSum(int[][]arr) {
        int n = arr.length, dr = n-1;        
        int[]prev = new int[n];
        
        for(int sr=dr; sr>=0; sr--){
            int[]curr = new int[n];
            for(int sc=dr; sc>=0; sc--){
                if(sr == dr){
                    curr[sc] = arr[sr][sc];
                    continue;
                } 
                int three = Integer.MAX_VALUE, two = Integer.MAX_VALUE, one = Integer.MAX_VALUE;
                
                one = prev[sc];
                if(sc != dr) two = prev[sc+1];
                if(sc != 0) three = prev[sc-1];
                
                curr[sc] = Math.min(three, Math.min(one,two)) + arr[sr][sc];
            }
            prev = curr;
        }
        int min = prev[0];
        for(int i=1; i<prev.length; i++) min = Math.min(min, prev[i]);
        return min;
    }
}