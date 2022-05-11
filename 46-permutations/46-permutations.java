class Solution {
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>al = new ArrayList<>();
        getPerm(nums, al, new ArrayList<>());
        return al;
    }
    
    public void getPerm(int[]arr, List<List<Integer>>ans, List<Integer>curr){
        if(arr.length == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        int n = arr.length;
        for(int i=0; i<n; i++){
            curr.add(arr[i]);
            int[]temp = new int[n-1];
            for(int k=0; k<i; k++) temp[k] = arr[k];
            for(int k=i+1; k<n; k++) temp[k-1] = arr[k];
            getPerm(temp, ans, curr);
            curr.remove(curr.size()-1);
        }
    }
}