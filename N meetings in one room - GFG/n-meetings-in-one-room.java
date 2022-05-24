// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int maxMeetings(int start[], int end[], int n)    {
        PriorityQueue<pair>pq = new PriorityQueue<>((a,b)->a.end - b.end);
        for(int i=0; i<start.length; i++) pq.add(new pair(start[i], end[i]));
        
        int max = 0;
        int curr = -1;
        while(pq.size()!=0){
            pair p = pq.remove();
            if(p.strt > curr){
                max ++;
                curr = p.end;
            }
        }
        return max;
    }
    public static class pair{
        int strt;
        int end;
        pair(int strt, int end){
            this.strt = strt;
            this.end = end;
        }
    }
}
