class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {
        int[]a1 = new int [n];
        int[]a2 = new int [n];
        
        Arrays.fill(a1, (int)1e5);
        Arrays.fill(a2, (int)1e5);
        
        a1[src] = 0;
        a2[src] = 0;
        
        for(int i=0; i<=k; i++){
            for(int[]flight:flights){
                a2[flight[1]] = Math.min(a1[flight[0]] + flight[2], a2[flight[1]]);
            }
            for(int j=0; j<a2.length; j++) a1[j] = a2[j];
        }
        
        return a1[dest] == (int)1e5 ? -1 : a1[dest];
    }
}