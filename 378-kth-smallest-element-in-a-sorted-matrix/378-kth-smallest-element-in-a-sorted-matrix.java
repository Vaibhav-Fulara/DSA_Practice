class Solution {
    public int kthSmallest(int[][] arr, int k) {
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j< arr[0].length; j++) {
                pq.add(arr[i][j]);
                if(pq.size() > k) pq.remove();
            }
        }
        return pq.peek();
    }
}