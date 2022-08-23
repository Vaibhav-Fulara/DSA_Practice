class Solution {
    public int longestSubarray(int[]arr, int k) {
        PriorityQueue<Integer>min = new PriorityQueue<>();
        PriorityQueue<Integer>max = new PriorityQueue<>((a,b)->b-a);
        
        int og = arr[0];
        int ans = 1;
        int j=0;
        
        for(int i=0; i<arr.length; i++) {
            min.add(arr[i]);
            max.add(arr[i]);
            while(max.peek() - min.peek() > k) {
                // System.out.println(min.peek() + " " + max.peek() + " " + arr[j]);
                // System.out.println(min + " " + max);
                min.remove(arr[j]);
                max.remove(arr[j++]);
            }
            ans = Math.max(ans, i-j+1);
        }
        
        return ans;
    }
}