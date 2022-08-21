class Solution {
    public int[] movesToStamp(String stamp, String target) {
        char[] S = stamp.toCharArray();                 // Convert stamp to char array
        char[] T = target.toCharArray();                // Convert target to char array
        List<Integer> res = new ArrayList<>();          // ArrayList to store answer
        boolean[] visited = new boolean[T.length];      // keeps note of is already entered
        int stars = 0;                                  // number of stars currently in the string
        
        while (stars < T.length) {                      // if(stars == target.length) we've reached target
            boolean doneReplace = false;                // swap parameter
            for (int i = 0; i <= T.length - S.length; i++) {
                if (!visited[i] && canReplace(T, i, S)) {       // 
                    stars = doReplace(T, i, S.length, stars);   // possible replacement. Hence, replace
                    doneReplace = true;                         // we've replaced in this solution making it                                                                          possible for more replacements to occur in next                                                                    steps
                    visited[i] = true;                          // do not add same i more than once
                    res.add(i);                                 // add to result arraylist
                    if (stars == T.length) {                    // we've reached the solution already
                        break;
                    }
                }
            }
            if (!doneReplace) return new int[0];        // no replacements possible now
        }
        
        int[] resArray = new int[res.size()];           // dump arraylist to array
        for (int i = 0; i < res.size(); i++) {          // traverse and add all elements
            resArray[i] = res.get(res.size() - i - 1);  // as objects have been entered from the beginning
        }
        return resArray;
    }
    
    private boolean canReplace(char[] T, int p, char[] S) {
        for (int i = 0; i < S.length; i++) {
            if (T[i + p] != '*' && T[i + p] != S[i]) {
                return false;           // checks for exact string copy so that it may be replaced
            }
        }
        return true;                    // exact string copy found. Now replace
    }
    
    private int doReplace(char[] T, int p, int len, int count) {
        for (int i = 0; i < len; i++) {
            if (T[i + p] != '*') {
                T[i + p] = '*';
                count++;
            }
        }
        return count;                   // returns count of new stars
    } 
}