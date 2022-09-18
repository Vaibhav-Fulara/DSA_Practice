class Solution {
    public int removeBoxes(int[] boxes) {
        Map<Integer, List<Integer>>hm = new HashMap<>();
        for(int i=0; i<boxes.length; i++) {
            int val = boxes[i];
            if(hm.containsKey(val)) hm.get(val).add(i);
            else {
                List<Integer>a = new ArrayList<>();
                a.add(i);
                hm.put(val, a);
            }
        }
        int[][][]dp = new int[boxes.length][boxes.length][boxes.length];
        for(int[][]ar:dp) for(int[]a:ar) Arrays.fill(a,-1);
        // return solve(boxes, dp, hm, 4, 5, 0);
        return solve(boxes, dp, hm, 0, boxes.length-1, 0);
    }
    public int solve(int[]arr, int[][][]dp, Map<Integer, List<Integer>>hm, int lo, int hi, int rep) {
        if(lo > hi) return 0;
        if(lo == hi) return (rep+1) * (rep+1);
        if(dp[lo][hi][rep] != -1) return dp[lo][hi][rep];
        int max = (rep+1)*(rep+1) + solve(arr, dp, hm, lo+1, hi, 0);
        List<Integer>al = hm.get(arr[lo]);
        for(int val:al) {
            if(val > lo && val <= hi) {
                max = Math.max(max, solve(arr, dp, hm, lo+1, val-1, 0) +
                                    solve(arr, dp, hm, val, hi, rep+1)
                );
            }
        }
        // System.out.println(lo + " "  + hi + " " + rep + " " + max);
        return dp[lo][hi][rep] = max;
    }
}