class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<List<Integer>>adj = new ArrayList<>();
        for(int i = 0; i <= 9; i++) adj.add(new ArrayList<>());
        for(int i = 0; i <= 9; i++) {
            if(i-k >= 0) adj.get(i).add(i-k);
            if(k!=0 && i+k <= 9) adj.get(i).add(i+k);
        }
        int tar = (int)(Math.pow(10,n-1));
        Set<Integer>al = new HashSet<>();
        for(int i=1; i<=9; i++) {
            solve(i, tar, al, adj);
        }
        int[]ans = new int[al.size()];
        int i=0;
        for(int val:al) ans[i++] = val;
        return ans;
    }
    public void solve(int curr, int tar, Set<Integer>al, List<List<Integer>>adj) {
        if(curr >= tar) {
            al.add(curr);
            return;
        }
        for(int val:adj.get(curr%10)) {
            int temp = curr*10 + val;
            solve(temp, tar, al, adj);
        }
    }
}