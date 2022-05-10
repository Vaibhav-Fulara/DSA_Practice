class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>al = new ArrayList<>();
        int[]arr = new int[50];
        Arrays.sort(candidates);
        getComb(candidates, target, al, new ArrayList<>(), 0);
        return al;
    }
    public void getComb(int[]arr, int tar, List<List<Integer>>result, List<Integer>al, int idx){
        if(tar==0) {result.add(new ArrayList<>(al)); return;}
        if(idx>=arr.length) return;
        if(tar>=arr[idx]){
            al.add(arr[idx]);
            getComb(arr, tar-arr[idx], result, al, idx+1);
            al.remove(al.size()-1);
        }
        while (idx!=arr.length-1 && arr[idx]==arr[idx+1]) idx++;
        if(idx!=arr.length-1) getComb(arr, tar, result, al, idx+1);
    }
}