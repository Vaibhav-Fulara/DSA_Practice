class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>al = new ArrayList<>();
        getSS(nums, al, new ArrayList<>(), 0);
        return al;
    }
    
    public void getSS(int[]arr, List<List<Integer>>al, List<Integer>curr, int idx){
        if(idx >= arr.length){al.add(new ArrayList<>(curr)); return;}
        int temp = arr[idx];
        curr.add(arr[idx]);
        getSS(arr, al, curr, idx+1);
        curr.remove(curr.size()-1);
        while(idx<arr.length && arr[idx] == temp) idx++;
        getSS(arr, al, curr, idx);
    }
}