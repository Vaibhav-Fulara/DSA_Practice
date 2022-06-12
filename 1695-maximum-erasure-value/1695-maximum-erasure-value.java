class Solution {
    public int maximumUniqueSubarray(int[]arr) {
        Set<Integer>hs = new HashSet<>();
        int i=0, j=0, curr = 0, max = 0;
        while(j != arr.length){
            if(!hs.contains(arr[j])){
                hs.add(arr[j]);
                curr += arr[j++];
            }
            else{
                max = Math.max(max, curr);
                while(hs.contains(arr[j])){
                    // System.out.println(arr[j] + " " + curr);
                    curr -= arr[i];
                    hs.remove(arr[i++]);
                }
            }
        }
        return Math.max(max, curr);
    }
}