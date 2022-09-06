class Solution {
    public int findMaxLength(int[] arr) {
        if(arr.length == 1) return 0;
        int[]ones = new int[arr.length];
        int[]zeroes = new int[arr.length];
        if(arr[0] == 0) zeroes[0] = 1;
        else ones[0] = 1;
        for(int i=1; i<arr.length; i++) {
            ones[i] = ones[i-1];
            zeroes[i] = zeroes[i-1];
            if(arr[i] == 0) {
                zeroes[i]++;
            } else {
                ones[i]++;
            }
        }
        int max = 0;
        Map<Integer, Integer>hm = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            int diff = zeroes[i] - ones[i];
            if(diff == 0) max = Math.max(max, i+1);
            if(hm.containsKey(diff)) {
                // System.out.println(diff + " " + hm.get(diff) + " " + i);
                max = Math.max(i-hm.get(diff), max);
            } else {
                hm.put(diff, i);
            }
        }
        return max;
    }
}