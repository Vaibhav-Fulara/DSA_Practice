class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<pair>pq = new PriorityQueue<>((a,b)->Double.compare(b.diff, a.diff));
        for(int i=0; i<points.length; i++){
            pair temp = new pair((double)Math.sqrt(Math.pow(points[i][0],2)+Math.pow(points[i][1],2)), points[i][0], points[i][1]);
            pq.add(temp);
            if(pq.size()>k) pq.poll();
        }
        int[][]ans = new int[k][2];
        int i=0;
        while(!pq.isEmpty()){
            pair temp = pq.poll();
            ans[i][0] = temp.x;
            ans[i++][1] = temp.y;
        }
        return ans;
    }
    public class pair{
        double diff;
        int x;
        int y;
        pair(){}
        pair(double diff,int x, int y){
            this.diff = diff;
            this.x = x;
            this.y = y;
        }
    }
}