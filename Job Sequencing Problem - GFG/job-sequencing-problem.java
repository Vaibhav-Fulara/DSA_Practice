// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}// } Driver Code Ends


class Solution{
    int[] JobScheduling(Job[] arr, int n) {
        int tmax = arr[0].deadline;
        
        Arrays.sort(arr, (a,b) -> {
            return b.profit - a.profit;
        });
        
        Set<Integer>hs = new HashSet<>();
        
        int count = 0, profit = 0;
        for(int i=0; i<arr.length; i++){
            Job job = arr[i];
            if(!hs.contains(job.deadline)){
                hs.add(job.deadline);
                count ++;
                profit += job.profit;
            }
            else{
                int t = job.deadline;
                while(t > 0 && hs.contains(t)) t--;
                if(t != 0){
                    hs.add(t);
                    count ++;
                    profit += job.profit;
                }
            }
        }
        return new int[] {count, profit};
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/