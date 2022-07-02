class Solution{	
    public int maxArea(int h, int w, int[] hor, int[] vert) {
        return (int) ((getMaxDist(h, hor) * getMaxDist(w, vert)) % ((int)1e9 + 7));
    }
    
    private long getMaxDist(int end, int[] cuts) {
        Arrays.sort(cuts);
        long res = 0, from = 0;
        for (int c : cuts) {
            res = Math.max(res, c - from);
            from = c;
        }
        return Math.max(res, end - from);
    }
}