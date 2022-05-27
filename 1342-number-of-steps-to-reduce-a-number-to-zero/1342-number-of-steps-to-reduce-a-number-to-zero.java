class Solution {
    public int numberOfSteps(int n) {
        int count = 0;
        while(n!=0){
            count++;
            if((n&1)==1 && n!=1) count++;
            n = n>>>1;
        }
        return count;
    }
}