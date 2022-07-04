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
    public int[] JobScheduling(Job arr[], int n) {
        Arrays.sort(arr, (a,b)->{
           return b.profit - a.profit; 
        });
        
        parent = new int[101];                  // as max days can be 100
        for(int i=0; i<101; i++) parent[i] = i;
        
        int profit = 0, jobs = 0;
        
        for(int i=0; i<n; i++){
            Job job = arr[i];
            int par = find(job.deadline);
            if(par == 0) continue;
            else{
                parent[par] = find(par-1);
                jobs++;
                profit += job.profit;
            }
        }
        return new int[]{jobs, profit};
    }
    
    int[]parent;
    
    public int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    public void union(int s1, int s2){
        if(s1 > s2) parent[s2] = s1;
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