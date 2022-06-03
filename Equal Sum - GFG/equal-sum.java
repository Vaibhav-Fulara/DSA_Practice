// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            String ans = new Solution().equilibrium(a, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String equilibrium(int arr[], int n) {
        int sum = 0;
        int []help = new int[n];
        
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            help[i] = sum;
            // System.out.print(help[i] + " ");
        }
        // System.out.println();
        
        for(int i=0; i<arr.length; i++){
            int val = help[i] - arr[i];
            int rsum = sum - arr[i];
            // System.out.println(val + " " + rsum);
            if(rsum % 2 != 0) continue;
            if(val == rsum/2) return "YES";
        }
        return "NO";
    }
}