// { Driver Code Starts
import java.util.*;

class Partition_Arr_To_K_Subsets
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++)
				a[i] = sc.nextInt();
			int k = sc.nextInt();
			Solution g = new Solution();
			if(g.isKPartitionPossible(a,n,k)==true)
				System.out.println(1);
			else 
				System.out.println(0);
			
		t--;
		}
	}
}// } Driver Code Ends


/*You are required to complete this method */

class Solution{
    public boolean isKPartitionPossible(int a[], int n, int k){
	    int sum = 0;
	    for(int val:a) sum += val;
	    Arrays.sort(a);
	    reverse(a);
	    if(sum % k != 0) return false;
	    int[]arr = new int[k];
	    return check(a, arr, sum/k, 0);
    }
    public void reverse(int[]arr){
        int lo = 0, hi = arr.length-1;
        while(lo < hi) {
            int temp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;
            lo++; hi--;
        }
    }
    public boolean check (int[]nums, int[]arr, int tar, int i) {
        if(i == nums.length) return true;
        for(int j=0; j<arr.length; j++) {
            if(arr[j] + nums[i] <= tar) {
                arr[j] += nums[i];
                if(check(nums, arr, tar, i+1)) return true;
                arr[j] -= nums[i];
            }
        }
        return false;
    }
}
