class Solution {
    public int binary(List<Integer>al, int y){
        int lo = 0, hi = al.size();
        while(lo<hi){
            int mid = lo+(hi-lo)/2;
            if(al.get(mid) < y) lo = mid+1;
            else hi = mid;
        }
        return lo;
    }
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        List<List<Integer>>al = new ArrayList<>(101);
        for(int i=0; i<=100; i++) al.add(new ArrayList<>());
        for(int[]rect:rectangles){
            int l = rect[0];
            int h = rect[1];
            al.get(h).add(l);
        }
        for(int i=0; i<=100; i++) Collections.sort(al.get(i));
        
        int[]arr = new int[points.length];
        for(int i=0; i<points.length; i++){
            int[]point = points[i];
            int x = point[0], y = point[1];
            if(x<0 || y<0) continue;
            for(int j=y; j<101; j++){
                List<Integer>temp = al.get(j);
                int no = binary(temp, x);
                arr[i]+=temp.size()-no;
            }
        }
        return arr;
    }
}