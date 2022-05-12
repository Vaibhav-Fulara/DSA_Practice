class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>al = new ArrayList<>();
        getSS(nums, al, 0, new ArrayList<>());
        return al;
    }
    
    public void getSS(int[]nums, List<List<Integer>>al, int idx, List<Integer>curr){
        if(idx == nums.length) {al.add(new ArrayList<>(curr)); return;}
        getSS(nums, al, idx+1, curr);
        curr.add(nums[idx]);
        getSS(nums, al, idx+1, curr);
        curr.remove(curr.size()-1);
    }
}