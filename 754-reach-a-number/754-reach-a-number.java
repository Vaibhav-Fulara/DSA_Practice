class Solution {
    public int reachNumber(int tar) {
        int x = 0;
        tar = Math.abs(tar);
        while(true) {
            int range = x*(x+1)/2;
            if(range >= tar && range % 2 == tar % 2) break;
            x++;
        }
        return x;
    }
}