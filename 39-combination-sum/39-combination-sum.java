class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>result = new ArrayList<>();
        getComb(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    public void getComb(List<List<Integer>>result, List<Integer>al, int[]arr, int tar, int idx){
        if(tar==0) {result.add(new ArrayList<>(al)); return;}
        if(idx==arr.length) return;
        if(arr[idx]<=tar){
            al.add(arr[idx]);
            getComb(result, al, arr, tar-arr[idx], idx);
            al.remove(al.size()-1);
        }
        getComb(result, al, arr, tar, idx+1);
    }
}