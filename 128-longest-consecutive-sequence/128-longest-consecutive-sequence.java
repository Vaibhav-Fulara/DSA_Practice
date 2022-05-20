class Solution {
    public int longestConsecutive(int[]arr) {
        if(arr.length == 0) return 0;
        int ans = 0;
        Set<Integer>hs = new HashSet<>();
        for(int val:arr) hs.add(val);
        for(int val:arr){
            if(!hs.contains(val-1)){
                int temp = 1;
                while(hs.contains(++val)) {
                    temp++;
                    hs.remove(val);
                }
                ans = Math.max(ans, temp);
            }
        }
        return ans;
    }
}