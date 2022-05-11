class Solution {
    public int numberOfBeams(String[] bank) {
        int pre = 0, ans = 0;
        for(String str:bank){
            int count = 0;
            for(char ch:str.toCharArray()) if (ch-'0' == 1) count++;
            if (count!=0){
                if (pre !=0) ans += pre*count;
                pre = count;
            }
        }
        return ans;
    }
}