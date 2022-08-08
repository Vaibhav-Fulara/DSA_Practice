class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer>al = new ArrayList<>();
        
        if(nums.length == 1) {
            al.add(0);
            return al;
        }
        
        List<Integer>sorted = new ArrayList<>();
        for(int y:nums) sorted.add(y);
        Collections.sort(sorted);
        
        int n = nums.length;
        
        for(int i=0; i<nums.length; i++){
            int val = nums[i];
            al.add(Math.min(n-1-i, find(sorted, val)));
        }
        
        return al;
    }
    
    public int find (List<Integer>arr, int tar) {
        int lo = 0, hi = arr.size();
        int ans = -1;
        while (hi >= lo) {
            int mid = lo + (hi-lo)/2;
            if(arr.get(mid) > tar) {
                hi = mid-1;
            } else if (arr.get(mid) < tar) {
                lo = mid+1;
            } else {
                ans = mid;
                hi = mid-1;
            }
        }
        arr.remove(ans);
        return ans;
    }
}