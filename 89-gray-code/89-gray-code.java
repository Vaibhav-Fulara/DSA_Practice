class Solution {
    final static Map<Integer, List<Integer>>hm = new HashMap<>();
    public List<Integer> grayCode(int n) {
        if(hm.containsKey(n)) return hm.get(n);
        if(n == 1) {
            List<Integer>ans = new ArrayList<>();
            ans.add(0);
            ans.add(1);
            hm.put(1, ans);
            return ans;
        }
        List<Integer>a = grayCode(n-1);
        List<Integer>al = new ArrayList<>();
        al.addAll(a);
        int i = al.size()-1;
        int bitmask = 1 << (n-1);
        while(i >= 0) {
            int num = al.get(i--);
            al.add(num | bitmask);
        }
        hm.put(n, al);
        return al;
    }
}