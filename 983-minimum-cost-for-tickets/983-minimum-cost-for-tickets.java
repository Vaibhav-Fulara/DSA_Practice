class Solution{
    public int mincostTickets(int[] days, int[] costs) {

       int n=days.length;
       int[] dp=new int[n+1];
       for(int i=n-1;i>-1;i--){
           int day,week,month;
           day = costs[0] + dp[binary (i+1, days[i]+1, days)];
           week= costs[1] + dp[binary(i+1, days[i]+7, days)];
           month= costs[2] + dp[binary(i+1, days[i]+30, days)];
           dp[i] = Math.min(day, Math.min(month,week));
       }
       return dp[0];
      
   }
   
   int binary(int strt, int end, int[] days){
       int lo=strt, hi = days.length-1;
       while(lo<=hi){
           int mid=(lo + hi)/2;
           if(days[mid] == end) return mid;
           else if(days[mid] < end) lo = mid+1;
           else hi = mid-1;
       }
       return lo;
   }
}