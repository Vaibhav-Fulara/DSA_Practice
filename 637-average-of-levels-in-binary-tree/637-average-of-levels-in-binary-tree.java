class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<List<Integer>>al = new ArrayList<>();
        getPath(root, al, 0);
        List<Double>ans = new ArrayList<>();
        for(List<Integer> list:al){
            long temp=0;
            for(int val:list) temp+=val;
            ans.add((double)temp/list.size());
        }
        return ans;
    }
    public void getPath(TreeNode root, List<List<Integer>>ans, int idx){
        if(root==null) return;
        if(idx>=ans.size()) ans.add(new ArrayList<>());
        ans.get(idx).add(root.val);
        getPath(root.left, ans, idx+1);
        getPath(root.right, ans, idx+1);
    }
}