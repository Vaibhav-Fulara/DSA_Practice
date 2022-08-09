class Solution {
    public int minBitFlips(int start, int goal) {
        int x = start ^ goal;
        int counter = 0;
        while(x != 0) {
            counter++;
            x -= x & -x;
        }
        return counter;
    }
}