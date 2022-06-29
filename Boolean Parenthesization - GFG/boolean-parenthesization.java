// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int[][][] dp;
    static int mod=1003;
    static int sol(String S,int i,int j,int istrue){
       
       if(i>j) return 0;
          
       if(i==j){
           if((istrue==1&&S.charAt(i)=='T')||(istrue==0&&S.charAt(i)=='F'))
                 return 1;
           else
              return 0;
    
       }
       if(dp[istrue][i][j]!=-1) return dp[istrue][i][j];
       int ans=0;
       
       for(int k=i+1;k<j;k+=2){
       
           int lt=sol(S,i,k-1,1);
           int lf=sol(S,i,k-1,0);
           int rt=sol(S,k+1,j,1);
           int rf=sol(S,k+1,j,0);

           if(S.charAt(k)=='|'){
               if(istrue==1)
                  ans=(ans+(lt*rt)%mod+(lf*rt)%mod+(lt*rf)%mod)%mod;
               else
                   ans=(ans+(lf*rf)%mod)%mod;
           }
           else if(S.charAt(k)=='&'){
               if(istrue==1)
                  ans=(ans+(lt*rt)%mod)%mod;
               else
                  ans=(ans+(lf*rf)%mod+(rf*lt)%mod+(lf*rt)%mod)%mod;
           }
           else if(S.charAt(k)=='^'){
               if(istrue==1)
                   ans=(ans+(rf*lt)%mod+(lf*rt)%mod)%mod;
               else
                   ans=(ans+(lt*rt)%mod+(lf*rf)%mod)%mod;
           }
           
           }
       
      
           return dp[istrue][i][j]=ans;
       
   }
    static int countWays(int N, String S){
 
   dp= new int[2][S.length()][S.length()];
     for(int i=0;i<2;i++){
       for(int j=0;j<S.length();j++){
           Arrays.fill(dp[i][j],-1);
       }
   }
    return  sol(S,0,N-1,1);
   }
}


