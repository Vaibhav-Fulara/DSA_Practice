class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer>hm = new HashMap<>();
        for(int val:arr) hm.put(val, hm.getOrDefault(val, 0) + 1);
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b) -> b-a);
        for(int key:hm.values()) pq.add(key);
        int size = 0;
        int sum = 0;
        while(size < (arr.length - arr.length/2)) {
            size += pq.remove();
            sum ++;
        }
        return sum;
    }
}