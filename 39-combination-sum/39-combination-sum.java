class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int tar) {
        List<List<Integer>>ans = new ArrayList<>();
        getSS(candidates, tar, ans, new ArrayList<>(), 0);
        return ans;
    }
    public void getSS(int[]arr, int tar, List<List<Integer>>ans, List<Integer>al, int lo){
        if(tar == 0){
            ans.add(new ArrayList(al));
            return;
        }
        for(int i=lo; i<arr.length; i++){
            int val = arr[i];
            al.add(val);
            if(val <= tar) getSS(arr, tar-val, ans, al, i);
            al.remove(al.size()-1);
        }
    }
}