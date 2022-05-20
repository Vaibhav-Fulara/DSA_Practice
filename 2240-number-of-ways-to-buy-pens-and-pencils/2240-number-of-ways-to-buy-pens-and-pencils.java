class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ans = 0;
        for(int i=0; i<=total; i+=cost2)  ans += (total-i)/cost1 + 1;
        return ans;
    }
}