class Solution {
    public int lengthOfLIS(int[] arr) {
        List<Integer>al = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            int j = binSearch(al, arr[i]);
            if(j == al.size()) al.add(arr[i]);
            else al.set(j, arr[i]);
        }
        return al.size();
    }
    public int binSearch(List<Integer>al, int val){
        int lo = 0;
        int hi = al.size();
        while(hi > lo){
            int mid = lo + (hi-lo)/2;
            if(al.get(mid) < val) lo = mid+1;
            else hi = mid;
        }
        return hi;
    }
}