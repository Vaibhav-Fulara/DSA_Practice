class Solution {
    public int carFleet(int target, int[] pos, int[] speed) {
        int i=0;
        int[]arr = new int[pos.length];
        for(int val:pos) arr[i++] = target - val;
        Map<Integer, Integer>hm = new HashMap<>();
        for(int j=0; j<arr.length; j++) {
            hm.put(arr[j], speed[j]);
        }
        Arrays.sort(arr);
        int count = 0;
        i = 0;
        while(i != arr.length) {
            int start = arr[i];
            int curr = hm.get(start);
            count++;
            while(i != arr.length && (long)start * hm.get(arr[i]) >= (long)arr[i] * curr) {
                i++;
            }
        }
        return count;
    }
}

