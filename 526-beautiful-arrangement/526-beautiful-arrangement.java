class Solution {
    public int countArrangement(int n) {
        boolean[]vis = new boolean[n+1];
        return solve(vis, n, 1);
    }
    public int solve(boolean[]vis, int n, int idx){
        if(idx == n+1) return 1;
        int ans = 0;
        for(int i = 1; i<=n; i++){
            if(!vis[i] && (i % idx == 0 || idx % i == 0)){
                vis[i] = true;
                ans += solve(vis, n, idx+1);
                vis[i] = false;
            }
        }
        return ans;
    }
}