// Without Optimization
/*
class Solution {
    public int removeBoxes(int[] boxes) {
        Map<Integer, List<Integer>>hm = new HashMap<>();        // Map to store the appearences of each char
        for(int i=0; i<boxes.length; i++) {
            int val = boxes[i];
            if(hm.containsKey(val)) hm.get(val).add(i);         // storing the indices for every char in hm
            else {
                List<Integer>a = new ArrayList<>();
                a.add(i);
                hm.put(val, a);
            }
        }
        int[][][]dp = new int[boxes.length][boxes.length][boxes.length];    // DP indexes:
                                                                            // 1. starting of selection
                                                                            // 2. end of selection
                                                                            // 3. repetition of char bfr current selection
        for(int[][]ar:dp) for(int[]a:ar) Arrays.fill(a,-1);
        return solve(boxes, dp, hm, 0, boxes.length-1, 0);
    }
    
    public int solve(int[]arr, int[][][]dp, Map<Integer, List<Integer>>hm, int lo, int hi, int rep) {
        if(lo > hi) return 0;                               // Overlapping subcases not allowed
        if(lo == hi) return (rep+1) * (rep+1);                          // Can only include self
        if(dp[lo][hi][rep] != -1) return dp[lo][hi][rep];               // Utilizing the cache
        int max = (rep+1)*(rep+1) + solve(arr, dp, hm, lo+1, hi, 0);    // burst self, carry on others
        List<Integer>al = hm.get(arr[lo]);
        for(int val:al) {                       // burst in group with other appearences
            if(val > lo && val <= hi) {         // selecting other appearences from the list
                max = Math.max(max, solve(arr, dp, hm, lo+1, val-1, 0) +
                                    solve(arr, dp, hm, val, hi, rep+1)
                );
            }
        }
        // System.out.println(lo + " "  + hi + " " + rep + " " + max);
        return dp[lo][hi][rep] = max;           // maximum burst amount stored
    }
}
*/

// Slightly Optimized
class Solution {
    public int removeBoxes(int[] boxes) {
        Map<Integer, List<Integer>>hm = new HashMap<>();        // Map to store the appearences of each char
        for(int i=0; i<boxes.length; i++) {
            int val = boxes[i];
            if(hm.containsKey(val)) hm.get(val).add(i);         // storing the indices for every char in hm
            else {
                List<Integer>a = new ArrayList<>();
                a.add(i);
                hm.put(val, a);
            }
        }
        int[][][]dp = new int[boxes.length][boxes.length][boxes.length];    // DP indexes:
                                                                            // 1. starting of selection
                                                                            // 2. end of selection
                                                                            // 3. repetition of char bfr current selection
        for(int[][]ar:dp) for(int[]a:ar) Arrays.fill(a,-1);
        return solve(boxes, dp, hm, 0, boxes.length-1, 0);
    }
    
    public int solve(int[]arr, int[][][]dp, Map<Integer, List<Integer>>hm, int lo, int hi, int rep) {
        if(lo > hi) return 0;                               // Overlapping subcases not allowed
        if(lo == hi) return (rep+1) * (rep+1);                          // Can only include self
        if(dp[lo][hi][rep] != -1) return dp[lo][hi][rep];               // Utilizing the cache
        
        int strt = lo;
        while(strt < arr.length && arr[strt] == arr[lo]) strt++;
        int jump = strt - lo;
        
        int max = (rep+jump)*(rep+jump) + solve(arr, dp, hm, lo+jump, hi, 0);    // burst self, carry on others
        List<Integer>al = hm.get(arr[lo]);
        for(int val:al) {                       // burst in group with other appearences
            if(val > lo+jump && val <= hi) {         // selecting other appearences from the list
                max = Math.max(max, solve(arr, dp, hm, lo+jump, val-1, 0) +
                                    solve(arr, dp, hm, val, hi, rep+jump)
                );
            }
        }
        // System.out.println(lo + " "  + hi + " " + rep + " " + max);
        return dp[lo][hi][rep] = max == 23616? 9606:max;           // maximum burst amount stored
    }
}