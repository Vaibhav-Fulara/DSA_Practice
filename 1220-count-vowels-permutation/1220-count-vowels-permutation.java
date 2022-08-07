// Recursion
// O(5^n) || O(n^2)
/*
class Solution {
    final int big = (int)(1e9+7);
    public int countVowelPermutation(int n) {
        char[]arr = new char[]{'a', 'e', 'i', 'o', 'u'};
        return solve(n, arr, -1);
    }
    public int solve(int n, char[]arr, int i) {
        if(n == 0) return 1;
        
        long ans = 0l;
        
        if(i == 0) {
            ans = solve(n-1, arr, 1) % big;
        } else if(i == 1) {
            ans += solve(n-1, arr, 0) % big;
            ans += solve(n-1, arr, 2) % big;
        } else if(i == 2) {
            for(int k=0; k<5; k++) {
                if(k == 2) continue;
                ans += solve(n-1, arr, k);
                ans %= big;
            }
        } else if(i == 3) {
            ans += solve(n-1, arr, 2) % big;
            ans += solve(n-1, arr, 4) % big;
        } else if(i == 4) {
            ans = solve(n-1, arr, 0) % big;
        } else {
            for(int k=0; k<5; k++) {
                ans += solve(n-1, arr, k);
                ans %= big;
            }
        }
        
        return (int)(ans % big);
    }
}
*/

// Memoization
// O(n*k) || O(n*k) + O(n**2)
/*
class Solution {
    final int big = (int)(1e9+7);
    
    public int countVowelPermutation(int n) {
        Integer[][]dp = new Integer[n+1][5];
        char[]arr = new char[]{'a', 'e', 'i', 'o', 'u'};
        return solve(n, arr, -1, dp);
    }
    
    public int solve(int n, char[]arr, int i, Integer[][]dp) {
        if(n == 0) return 1;
        
        if(i != -1 && dp[n][i] != null) return dp[n][i];
        long ans = 0l;
        
        if(i == 0) {
            ans = solve(n-1, arr, 1, dp) % big;
        } else if(i == 1) {
            ans += solve(n-1, arr, 0, dp) % big;
            ans += solve(n-1, arr, 2, dp) % big;
        } else if(i == 2) {
            for(int k=0; k<5; k++) {
                if(k == 2) continue;
                ans += solve(n-1, arr, k, dp);
                ans %= big;
            }
        } else if(i == 3) {
            ans += solve(n-1, arr, 2, dp) % big;
            ans += solve(n-1, arr, 4, dp) % big;
        } else if(i == 4) {
            ans = solve(n-1, arr, 0, dp) % big;
        } else {
            for(int k=0; k<5; k++) {
                ans += solve(n-1, arr, k, dp);
                ans %= big;
            }
        }
        
        if(i == -1) return (int)(ans % big);
        return dp[n][i] = (int)(ans % big);
    }
}
*/

// Tabulation
// O(n*k) || O(n*k)
/*
class Solution {
    public int countVowelPermutation(int n) {
        
        long big = (long)(1e9 + 7);
        long[][] dp = new long[n+1][6];
        
        Arrays.fill(dp[0], 1);
        for(int len=1 ;len<=n ;len++) {
            for(int last=0 ;last<=5 ;last++) {
                long count = 0;
                if(last == 2) 
                    count = (count + dp[len - 1][1]) % big;
                if(last == 1 || last == 3)
                    count = (count + dp[len - 1][2]) % big;
                if(last == 1 || last == 2 || last == 4 || last == 5)
                    count = (count + dp[len - 1][3]) % big;
                if(last == 3 || last == 5)
                    count = (count + dp[len - 1][4]) % big;
                if(last == 1)
                    count = (count + dp[len - 1][5]) % big;
                if(last == 0) {
                    for(int i=1 ;i<=5 ;i++) {
                        count = (count + dp[len - 1][i]) % big;
                    }
                }
                
                dp[len][last] = count % big;
            }
        }
        return (int)dp[n][0];
    }
}
*/

// Space optimization
// O(n*k) || O(k)
class Solution {
    public int countVowelPermutation(int n) {
        
        long big = (long)(1e9 + 7);
        long[]old = new long[6];
        
        Arrays.fill(old, 1);
        for(int len=1; len<=n; len++) {
            long[]mod = new long[6];
            for(int last=0; last<=5; last++) {
                long count = 0;
                if(last == 2) 
                    count = (count + old[1]) % big;
                if(last == 1 || last == 3)
                    count = (count + old[2]) % big;
                if(last == 1 || last == 2 || last == 4 || last == 5)
                    count = (count + old[3]) % big;
                if(last == 3 || last == 5)
                    count = (count + old[4]) % big;
                if(last == 1)
                    count = (count + old[5]) % big;
                if(last == 0) {
                    for(int i=1 ;i<=5 ;i++) {
                        count = (count + old[i]) % big;
                    }
                }
                
                mod[last] = count % big;
            }
            old = mod;
        }
        return (int)old[0];
    }
}