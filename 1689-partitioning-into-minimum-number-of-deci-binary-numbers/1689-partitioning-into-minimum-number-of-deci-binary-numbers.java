class Solution {
    public int minPartitions(String s) {
        int max = 0;
        for(char ch:s.toCharArray()){
            int n = ch-'0';
            if(n == 9) return 9;
            max = Math.max(max, n);
        }
        return max;
    }
}