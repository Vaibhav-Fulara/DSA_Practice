class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer>qu = new ArrayDeque<>();
        for(int i=1; i<=n; i++) qu.add(i);
        while(! (qu.size() == 1)) {
            for(int i=1; i<k; i++) {
                qu.add(qu.remove());
            }
            qu.remove();
        }
        return qu.remove();
    }
}