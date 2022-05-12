class Solution {
    public List<Integer> getRow(int row) {
        List<Integer>al = new ArrayList<>();
        long val = 1;
        for(int i=0; i<=row; i++) {
            al.add((int)val);
            val = val*(row-i)/(i+1);
        }
        return al;
    }
}