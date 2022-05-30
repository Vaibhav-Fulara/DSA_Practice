class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>>al = new ArrayList<>();
        Arrays.sort(nums);
        getSS(nums, al, 0, new ArrayList<>());
        return al;
    }
    public void getSS(int[]arr, List<List<Integer>>al, int i, List<Integer>curr){
        if(i == arr.length) {al.add(new ArrayList(curr)); return;}
        
        int j = i;
        while(j<arr.length-1 && arr[j+1] == arr[j]) j++;
        getSS(arr, al, j+1, curr);
        
        curr.add(arr[i]);
        getSS(arr, al, i+1, curr);
        curr.remove(curr.size()-1);
    }
}