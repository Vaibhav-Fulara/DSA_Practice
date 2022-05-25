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
        int dp1 = 0;
        int dp2 = 0;
        for(int i=n-1; i>=0; i--){
            if(i==n-1) {dp2 = arr[i]; continue;}
            if(i==n-2) {dp1 = Math.max(arr[i],arr[i+1]); continue;}
            int pick = arr[i] + dp2;
            int notpick = dp1;
            dp2 = dp1;
            dp1 = Math.max(pick, notpick);
        }
        return dp1 == 0? dp2:dp1;
    }
}