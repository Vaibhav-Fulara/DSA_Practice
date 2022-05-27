class Solution {
    public int minMoves(int tar, int maxDoubles) {
        int min = 0;
        while(tar!=1 && maxDoubles>0){
            min++;
            if(tar % 2 == 1) min++;
            maxDoubles--;
            tar >>= 1;
        }
        min += tar-1;
        return min;
    }
}