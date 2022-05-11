class Solution {
    public int countVowelStrings(int n) {
        return getCount(n, 0);
    }
    public int getCount(int n, int idx){
        if(n==0) return 1;
        if(n<0 || idx>4) return 0;
        int count = 0;
        count += getCount(n-1, idx);
        count += getCount(n, idx+1);
        return count;
    }
}