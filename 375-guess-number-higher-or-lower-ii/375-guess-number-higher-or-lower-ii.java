// class Solution {
//     static int[]sum = new int[201];
//     static boolean bool = false;
//     public int getMoneyAmount(int n) {
//         if(!bool){
//             bool = true;
//             for(int i=1; i<201; i++) sum[i] = sum[i-1] + i;
//         }
//         return getCoin(1, n);
//     }
//     public int getCoin(int lo, int hi){
//         System.out.println(lo + " " + hi);
//         if(lo == hi) return 0;
        
//         int diff = sum[hi] - sum[lo];
//         int gross = diff/2;
//         int t = lo;
//         while(gross >= sum[t]) t++;
//         if(t < lo)
        
//         return t + Math.max(getCoin(lo, t-1), getCoin(t+1, hi));
//     }
// }

class Solution {
    int[][] best;
    public int getMoneyAmount(int n) {
        best = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(best[i], -1);
        }
        return dp(1, n);
    }
    
    private int dp(int lo, int hi) {
        if (lo >= hi) {
            return 0;
        } else {
            if (best[lo][hi] != -1) {
                return best[lo][hi];
            }
            //the idea is to  compute the maximum amount of money I need to pay with my guesses ranging from lo to hi.
            //Since I want to minimize my payoff, I'll choose the starting point [lo,hi] that has the minimum payoff.
            //But for each starting point, I'll choose the maximum amount of money I pay, since I need the worst case scenario.
            int res = Integer.MAX_VALUE;
            for (int i = lo; i <= hi; i++) {
                int op1 = i + dp(lo, i - 1);//guess = i = wrong, go lo
                int op2 = i + dp(i + 1, hi);//guess = i = wrong, go hi
                int out = Math.max(op1, op2);
                res = Math.min(out, res);
            }
            best[lo][hi] = res;
            return res;
        }
    }       
}