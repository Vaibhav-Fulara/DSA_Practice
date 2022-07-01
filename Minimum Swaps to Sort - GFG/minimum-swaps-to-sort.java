// { Driver Code Starts
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
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends

// TC = O(nlogn)
class Solution{
    public int minSwaps(int []nums){
        HashMap<Integer, Integer>hm = new HashMap<>();
        for(int i=0; i<nums.length; i++) hm.put(nums[i], i);
        boolean[]vis = new boolean[nums.length];

        Arrays.sort(nums);
        int ans = 0;
        
        for(int i=0; i<nums.length; i++){
            if(i != hm.get(nums[i]) && vis[i] == false){
                vis[i] = true;
                
                int j = i;
                int csize = 0;
                do{
                    j = hm.get(nums[j]);
                    vis[j] = true;
                    csize++;
                } while(j != i);
                ans += csize-1;
            }
        }
        return ans;
    }
}