// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int LongestBitonicSequence(int[]arr){
        int[]front = new int[arr.length];
        int[]back = new int[arr.length];
        Arrays.fill(front, 1);
        Arrays.fill(back, 1);
        
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i] && front[j]+1 > front[i]){
                    front[i] = front[j] + 1;
                }
            }
        }
        
        for(int i=arr.length-1; i>=0; i--){
            for(int j=arr.length-1; j>i; j--){
                if(arr[i] > arr[j] && back[j] + 1 > back[i]){
                    back[i] = back[j]+1;
                }
            }
        }
        
        int max = 1;
        for(int i=0; i<arr.length; i++) max = Math.max(max, front[i]+back[i]-1);
        return max;
    }
}