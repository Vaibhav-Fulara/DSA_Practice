class Solution {
    public int countArrangement(int n) {
        Set<Integer>hs = new HashSet<>();
        for(int i=1; i<=n; i++) hs.add(i);
        return solve(hs, n, 1);
    }
    public int solve(Set<Integer>hs, int n, int idx){
        if(hs.isEmpty()) return 1;
        int ans = 0;
        for(int i = 1; i<=n; i++){
            if(hs.contains(i) && (i % idx == 0 || idx % i == 0)){
                hs.remove(i);
                ans += solve(hs, n, idx+1);
                hs.add(i);
            }
        }
        return ans;
    }
}