class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer>qu = new ArrayDeque<>();
        for(int i=1; i<=n; i++) qu.add(i);
        return solve(qu, k);
    }
    public int solve(Queue<Integer>qu, int k) {
        if(qu.size() == 1) return qu.remove();
        for(int i=1; i<k; i++) {
            qu.add(qu.remove());
        }
        qu.remove();
        return solve(qu, k);
    }
}