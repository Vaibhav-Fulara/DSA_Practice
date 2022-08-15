class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        TreeSet<Integer>ts = new TreeSet<>();
        for(int[]point:points) {
            ts.add(point[0]);
        }
        int old = -1;
        int max = 0;
        while(!ts.isEmpty()) {
            int temp = ts.pollFirst();
            if(old != -1) max = Math.max(max, temp-old);
            old = temp;
        }
        return max;
    }
}