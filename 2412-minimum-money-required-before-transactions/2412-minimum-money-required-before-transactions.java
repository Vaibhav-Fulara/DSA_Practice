class Solution {
    public long minimumMoney(int[][] transactions) {
        List<int[]>a1 = new ArrayList<>();
        List<int[]>a2 = new ArrayList<>();
        for(int[]a:transactions) {
            if(a[0] > a[1]) a1.add(a);
            else a2.add(a);
        }
        Collections.sort(a1, (a,b) -> {
            return a[1] - b[1];
        });
        Collections.sort(a2, (a,b) -> {
            return b[0] - a[0];
        });
        long cost = 0;
        long curr = 0;
        for(int[]a:a1) {
            if(curr < a[0]) {
                cost += a[0] - curr;
                curr = a[1];
            } else {
                curr -= a[0];
                curr += a[1];
            }
        }
        for(int[]a:a2) {
            if(curr < a[0]) {
                cost += a[0] - curr;
                curr = a[1];
            } else {
                curr -= a[0];
                curr += a[1];
            }
        }
        return cost;
    }
}