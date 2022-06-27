class Solution {
    public int minPartitions(String s) {
        int max = 0;
        for(char ch:s.toCharArray()){
            max = Math.max(max, ch-'0');
        }
        return max;
    }
}