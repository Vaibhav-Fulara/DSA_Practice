class Solution {
    public int minimumTotal(List<List<Integer>> al) {
        int n = al.size();
        
        int[]prev = new int[n];
        
        int dr = n-1;
        for(int sr=dr; sr>=0; sr--){
            int[]curr = new int[n];
            for(int sc = sr; sc>=0; sc--){
                if(sr == dr || sc == dr){
                    curr[sc] = al.get(sr).get(sc);
                    continue;
                } 

                int one = prev[sc];
                int two = prev[sc+1];

                curr[sc] = Math.min(one, two) + al.get(sr).get(sc);
            }
            prev = curr;
        }
        return prev[0];
    }
}