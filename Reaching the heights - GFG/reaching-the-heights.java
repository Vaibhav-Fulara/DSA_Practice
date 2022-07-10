// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int N = Integer.parseInt(element[0]);
		    int arr [] = new int[N];
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<N;i++){
	            arr[i] = Integer.parseInt(elements[i]);    
	        }
		    
		    
		    Complete obj = new Complete();
		    ArrayList<Integer> ans;
		    ans = obj.reaching_height(N, arr);
        	
        	if(ans.size() == 1 && ans.get(0) == -1){
        	    System.out.println("Not Possible");
        	    continue;
        	}
        	
        	for(int i: ans)
        	    System.out.print(i + " ");
        	System.out.println();
		}
	}
}






// } Driver Code Ends


//User function Template for Java


class Complete{
    public static ArrayList<Integer> reaching_height (int n, int ar[]) {
        Arrays.sort(ar);
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
           arr[i]=ar[n-i-1];
        }
        ArrayList<Integer> ans=new ArrayList<>();
        if(n>1 && arr[0]==arr[n-1]){
           ans.add(-1);
           return ans;
        }
        
        int l=0,r=n-1;
        while(l<r){
           ans.add(arr[l++]);
           ans.add(arr[r--]);
        }
        if(l==r) ans.add(arr[l]);
        return ans;
    }
}
