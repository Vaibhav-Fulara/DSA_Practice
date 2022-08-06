class Solution {
    public List<Integer> grayCode(int n) {
        if(n == 1) {
            List<Integer>ans = new ArrayList<>();
            ans.add(0);
            ans.add(1);
            return ans;
        }
        List<Integer>al = grayCode(n-1);
        int i = al.size()-1;
        int bitmask = 1 << (n-1);
        while(i >= 0) {
            int num = al.get(i--);
            al.add(num | bitmask);
        }
        return al;
    }
}