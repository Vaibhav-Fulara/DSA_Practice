class Solution {
    public double angleClock(int hour, int min) {
        hour %= 12;
        double d1 = hour*30 + (double)min * 0.5;
        double d2 = min * 6;
        double res = Math.abs(d1-d2);
        return res <= 180 ? res:360-res;
    }
}