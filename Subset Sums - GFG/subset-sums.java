// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}
// } Driver Code Ends

class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer>al = new ArrayList<>();
        getSum(al, arr, N, 0, 0);
        return al;
    }
    void getSum(ArrayList<Integer>al, ArrayList<Integer>arr, int n, int i, int sum){
        if(i==n){
            al.add(sum);
            return;
        }
        getSum(al, arr, n, i+1, sum);
        getSum(al, arr, n, i+1, sum+arr.get(i));
    }
}