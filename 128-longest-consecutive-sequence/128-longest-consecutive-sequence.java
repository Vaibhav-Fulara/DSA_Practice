class Solution {
    public int longestConsecutive(int[] arr) {
        if(arr.length == 0) return 0;
        Set<Integer>dict = new HashSet<>();
        for(int val:arr) {
            dict.add(val);
        }
        int max = 1;
        for(int val:arr){
            if(dict.contains(val-1)) continue;
            int size = 1;
            while(dict.contains(val + 1)){
                size++;
                dict.remove(val);
                val++;
            } 
            max = Math.max(max, size);
        }
        return max;
    }
}