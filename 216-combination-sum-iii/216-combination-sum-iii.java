class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>result = new ArrayList<>();
        getComb(k, n, result, 1, new ArrayList<>());
        return result;
    }
    public void getComb(int k , int tar, List<List<Integer>>result, int idx, List<Integer>al){
        if(tar==0 && al.size()==k) {result.add(new ArrayList(al)); return;}
        if(idx > 9 || al.size() == k) return;
        if(tar >= idx){
            al.add(idx);
            getComb(k, tar-idx, result, idx+1, al);
            al.remove(al.size()-1);
        }
        getComb(k, tar, result, idx+1, al);
    }
}