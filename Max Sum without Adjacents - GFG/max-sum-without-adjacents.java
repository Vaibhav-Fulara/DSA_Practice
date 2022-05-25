// { Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxSum(int arr[], int n) {
        int[]dp = new int[n];
        for(int i=n-1; i>=0; i--){
            if(i==n-1) {dp[i] = arr[i]; continue;}
            if(i==n-2) {dp[i] = Math.max(arr[i],arr[i+1]); continue;}
            int pick = arr[i] + dp[i+2];
            int notpick = dp[i+1];
            dp[i] = Math.max(pick, notpick);
        }
        return dp[0];
    }
}