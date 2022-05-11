class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>al = new ArrayList<>();
        getComb(al, n, k, new ArrayList<>());
        return al;
    }
    public void getComb(List<List<Integer>>al, int n, int k, List<Integer>curr){
        if(curr.size()==k){
            al.add(new ArrayList<>(curr));
            return;
        }
        if(n<=0) return;
        curr.add(n);
        getComb(al, n-1, k, curr);
        curr.remove(curr.size()-1);
        getComb(al, n-1, k, curr);
    }
}