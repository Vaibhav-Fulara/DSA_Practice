class Solution {
    public int[] twoSum(int[]arr, int target) {
        HashMap<Integer, Integer>hm = new HashMap<>();
        for(int i=0; i<arr.length; i++) hm.put(arr[i], i);
        
        for(int i=0; i<arr.length; i++){
            int n = target - arr[i];
            if(hm.containsKey(n) && hm.get(n) > i) return new int[]{i, hm.get(n)};
        } 
        
        return new int[1];
    }
}