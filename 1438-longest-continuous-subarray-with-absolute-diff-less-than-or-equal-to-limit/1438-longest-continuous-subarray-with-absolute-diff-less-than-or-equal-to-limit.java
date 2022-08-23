class Solution {
    public int longestSubarray(int[] arr, int k) {
        Deque<Integer>min = new ArrayDeque<>();
        Deque<Integer>max = new ArrayDeque<>();
        int i=0;
        int ans = 0;
        for(int j=0; j<arr.length; j++) {
            while(!min.isEmpty() && arr[j]  < min.peekLast()) min.pollLast();
            while(!max.isEmpty() && arr[j]  > max.peekLast()) max.pollLast();
            min.add(arr[j]);
            max.add(arr[j]);
            while(max.peek() - min.peek() > k) {
                if(max.peek() == arr[i]) max.poll();
                if(min.peek() == arr[i]) min.poll();
                i++;
            }
            ans = Math.max(j-i+1, ans);
        }
        return ans;
    }
}